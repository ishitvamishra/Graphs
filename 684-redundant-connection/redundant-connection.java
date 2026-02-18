class Solution {
    private boolean dfs(int src, int target, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        //suppose(2,3) ke liye check kr rhey toh neighbour track krte krte hm ek point pe
        //same node pe aajayenge agar cycle hui toh aur usi samay pe true return krdenge
        if (src == target) return true;

        vis[src] = true;

        for (int nei : adj.get(src)) {
            if (!vis[nei]) {
                if (dfs(nei, target, vis, adj))
                    return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] vis = new boolean[n + 1];

            // Check: is there already a path between u and v agar hai toh 
            if (!adj.get(u).isEmpty() && !adj.get(v).isEmpty()) {
                if (dfs(u, v, vis, adj)) {
                    return edge;   // this edge creates cycle
                }
            }

            // Otherwise add edge to graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }
}
