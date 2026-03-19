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
    public int minConnect(int n, int[][] edges) {
        // code here
        int extraEdges = 0;
        DisjointSet ds = new DisjointSet(n);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(ds.findUPar(u) == ds.findUPar(v)) extraEdges++;

            else{
                ds.unionBySize(u,v);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i) cnt++;
        }

        int ans = cnt - 1;
        if(extraEdges >= ans){
            return ans;
        }
        return -1;
    }
}
