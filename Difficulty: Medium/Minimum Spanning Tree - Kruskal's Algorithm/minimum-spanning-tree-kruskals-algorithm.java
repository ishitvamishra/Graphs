// User function Template for Java
class Solution {
    static class DisjointSet{
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
    
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        
        Arrays.sort(edges, (a,b) -> a[2] - b[2]);
        int mstWt = 0;
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(ds.findUPar(u) != ds.findUPar(v)){
                mstWt += w;
                ds.unionBySize(u,v);
            }
        }
        
        return mstWt;
    }
}
