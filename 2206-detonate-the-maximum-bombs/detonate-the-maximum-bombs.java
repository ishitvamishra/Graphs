class Solution {
    public int dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        int count = 1;
        for(int x: adj.get(node)){
            if(!vis[x]){
                count += dfs(x, vis, adj);
            }
        }
        return count;
    }
    public int maximumDetonation(int[][] bombs) {
        int V = bombs.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for(int j = 0; j < V; j++){
                if(i == j) continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x2 - x1;
                long dy = y2 - y1;

                if(dx*dx + dy*dy <= r1*r1){
                    adj.get(i).add(j);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < V; i++){
            boolean vis[] = new boolean[V];
            max = Math.max(max, dfs(i, vis, adj));
        }
        return max;
    }
}