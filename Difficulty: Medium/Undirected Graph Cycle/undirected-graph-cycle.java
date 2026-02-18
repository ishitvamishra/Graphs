class Solution {
    private boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        
        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(dfs(adjNode, node, vis, adj)) return true;
            }
            else if(parent != adjNode) return true;
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        // Build graph using edges
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
}
