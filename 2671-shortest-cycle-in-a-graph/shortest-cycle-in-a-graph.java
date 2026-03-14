class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = Integer.MAX_VALUE;

        for(int start = 0; start < n; start++){
            int[] dist = new int[n];
            Queue<Integer> q = new LinkedList<>();

            Arrays.fill(dist, -1);

            dist[start] = 0;
            q.offer(start);

            while(!q.isEmpty()){
                int node = q.poll();

                for(int nei : adj.get(node)){
                    if(dist[nei] == -1){
                        dist[nei] = dist[node] + 1;
                        q.offer(nei);
                    }

                    else if(dist[nei] >= dist[node]){
                        int cycleLen = dist[node] + dist[nei] + 1;
                        ans = Math.min(ans, cycleLen);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}