class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] vis){
        vis[node] = true;

        for(int it : adjList.get(node)){
            if(!vis[it]){
                dfs(it, adjList, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean vis[] =  new boolean[V];
        int count = 0;
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                count++;
                dfs(i, adjList, vis);
            }
        }
        return count;
    }
}