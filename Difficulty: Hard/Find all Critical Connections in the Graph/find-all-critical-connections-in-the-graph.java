import java.util.*;

class Solution {
    private int timer = 1;

    private void dfs(int node, int parent, int[] vis,
                     ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low,
                     ArrayList<ArrayList<Integer>> bridges) {

        vis[node] = 1;
        tin[node] = low[node] = timer++;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;

            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, bridges);

                low[node] = Math.min(low[node], low[it]);

                if (low[it] > tin[node]) {
                    int u = Math.min(node, it);
                    int v = Math.max(node, it);
                    bridges.add(new ArrayList<>(Arrays.asList(u, v)));
                }
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> criticalConnections(
            int n, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, adj, tin, low, bridges);
            }
        }

        // SORT FINAL ANSWER
        Collections.sort(bridges, (a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            }
            return a.get(1) - b.get(1);
        });

        return bridges;
    }
}