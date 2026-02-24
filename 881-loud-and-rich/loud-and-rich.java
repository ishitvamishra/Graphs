class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int V = quiet.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int[] edge : richer){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[V];

        for(int i = 0; i < V; i++){
            ans[i] = i;
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbour : adj.get(node)){

                if(quiet[ans[node]] < quiet[ans[neighbour]]){
                    ans[neighbour] = ans[node];
                }

                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return ans;
    }
}