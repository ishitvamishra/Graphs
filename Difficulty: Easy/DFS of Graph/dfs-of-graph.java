class Solution {
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
        vis[node] = true;
        res.add(node);
        
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, adj, res);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[n];
        dfs(0, vis, adj, res);
        return res;
    }
}