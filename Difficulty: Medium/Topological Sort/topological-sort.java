class Solution {
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>>adj, Stack<Integer> st){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it, vis,adj, st);
            }
        }
        st.push(node);
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
}