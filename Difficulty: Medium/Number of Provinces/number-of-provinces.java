// User function Template for Java

class Solution {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] vis){
        vis[node] = true;
        for(int it : adjList.get(node)){
            if(!vis[it]){
                dfs(it, adjList, vis);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                count++;
                dfs(i, adjList, vis);
            }
        }
        return count;
    }
}