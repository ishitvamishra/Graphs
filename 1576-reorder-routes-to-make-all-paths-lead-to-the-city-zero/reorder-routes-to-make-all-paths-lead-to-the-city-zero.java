class Solution {

    class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minReorder(int n, int[][] connections) {

        List<Pair>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            adj[u].add(new Pair(v, 1));
            adj[v].add(new Pair(u, 0));
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int ans = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (Pair nbr : adj[node]) {

                if (!vis[nbr.node]) {

                    vis[nbr.node] = true;
                    ans += nbr.cost;
                    q.offer(nbr.node);
                }
            }
        }

        return ans;
    }
}