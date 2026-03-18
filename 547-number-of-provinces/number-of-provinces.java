class DisjointSet{
    int[] parent;;
    int[] size;
        
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
            
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
        
    int findUPar(int node){
        if(node == parent[node]){
            return node;
        }
            
        return parent[node] = findUPar(parent[node]);
    }
        
    void unionBySize(int u, int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
            
        if(pu == pv) return;
            
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] = size[pv] + size[pu];
        } 
            
        else{
            parent[pv] = pu;
            size[pu] = size[pu] + size[pv];
        }
    }

}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        
        DisjointSet ds = new DisjointSet(V);

        for(int i = 0; i < V; i++){
            
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < V; i++){
            if(ds.parent[i] == i) cnt++;
        }
        return cnt;
    }
}