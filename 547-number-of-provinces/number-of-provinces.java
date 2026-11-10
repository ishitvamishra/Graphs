class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;

        for(int next : adj.get(node)){
            if(!visited[next]){
                dfs(next, adj, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] != 0 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                cnt++;
                dfs(i, adj, visited);
            }
        }

        return cnt;
    }
}