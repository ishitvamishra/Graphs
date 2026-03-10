class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        long INF = (long)1e18;
        long[] dist = new long[n];

        Arrays.fill(dist, INF);
        dist[0] = 0;

        for(int i = 0; i < n-1; i++){

            for(int[] e : edges){

                int u = e[0];
                int v = e[1];
                int w = e[2] + 1;

                if(dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;

                if(dist[v] + w < dist[u])
                    dist[u] = dist[v] + w;
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++)
            if(dist[i] <= maxMoves)
                ans++;

        for(int[] e : edges){

            int u = e[0];
            int v = e[1];
            int cnt = e[2];

            long a = dist[u] > maxMoves ? 0 : maxMoves - dist[u];
            long b = dist[v] > maxMoves ? 0 : maxMoves - dist[v];

            ans += Math.min(cnt, (int)(a + b));
        }

        return ans;
    }
}