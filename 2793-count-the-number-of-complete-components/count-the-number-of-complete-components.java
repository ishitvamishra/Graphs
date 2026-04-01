class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] res = dfs(i, adj, visited);
                int nodes = res[0];
                int degreeSum = res[1];
                
                int edgeCount = degreeSum / 2;
                
                //complete graph condition
                if (edgeCount == (nodes * (nodes - 1)) / 2) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private int[] dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        
        // har node ke degree ka sum lelo 
        int nodes = 1;
        int degreeSum = adj.get(node).size();
        
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                int[] res = dfs(nei, adj, visited);
                nodes += res[0];
                degreeSum += res[1];
            }
        }
        
        return new int[]{nodes, degreeSum};
    }
}