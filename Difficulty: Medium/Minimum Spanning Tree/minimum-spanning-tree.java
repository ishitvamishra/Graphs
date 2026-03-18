//Prims Algorithm
// class Pair{
//     int node;
//     int wt;
    
//     Pair(int node, int wt){
//         this.node = node;
//         this.wt = wt;
//     }
// }
// class Solution {
//     public int spanningTree(int V, int[][] edges) {
//         // code here
//         List<List<Pair>> adj = new ArrayList<>();
//         for(int i = 0; i <V; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int[] edge : edges){
//             int u = edge[0];
//             int v = edge[1];
//             int w = edge[2];
            
//             adj.get(u).add(new Pair(v,w));
//             adj.get(v).add(new Pair(u,w));
            
//         }
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
//         int[] vis = new int[V];
//         //not including parent because mst is not asked just min sum is asked
//         pq.add(new Pair(0,0));
//         int sum = 0;
        
//         while(!pq.isEmpty()){
//             int node = pq.peek().node;
//             int wt = pq.peek().wt;
//             pq.remove();
            
//             if(vis[node] == 1) continue;
            
//             vis[node] = 1;
//             sum += wt;
            
//             for(Pair nei : adj.get(node)){
//                 int adjNode = nei.node;
//                 int adjWt = nei.wt;
                
//                 if(vis[adjNode] == 0){
//                     pq.add(new Pair(adjNode, adjWt));
//                 }
//             }
//         }
//         return sum;
//     }
// }

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
    
    public int spanningTree(int V, int[][] edges) {
        
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
