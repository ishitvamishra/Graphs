class Solution {
    public boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[node] = col;
        
        for(int it : adj.get(node)){
            if(color[it] == -1){
                if(dfs(it, 1-col, color, adj) == false) return false;
            }
            else if(color[it] == col) return false;
        }
        return true;
    }
    
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[V];
        for(int i = 0; i <V; i++) color[i] = -1;
        
        for(int i = 0; i <V; i++){
            if(color[i] == -1){
                if(dfs(i, 0, color, adj) == false) return false;
            }
        }
        return true;
    }
}