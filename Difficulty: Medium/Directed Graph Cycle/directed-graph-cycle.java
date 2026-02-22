class Solution {
    private boolean dfs(int node, int[] vis, int[] pathVis, List<List<Integer>> adj){
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, vis, pathVis, adj)) return true;
            }
            else if (pathVis[it] == 1) return true;
        }
        pathVis[node] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(dfs(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }
}