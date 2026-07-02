class Solution {

    public static int[] dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        int nodes = 1;
        int degreeSum = adjList.get(node).size();

        for (int next : adjList.get(node)) {
            if (!visited[next]) {
                int[] res = dfs(next, adjList, visited);
                nodes += res[0];
                degreeSum += res[1];
            }
        }

        return new int[]{nodes, degreeSum};
    }

    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[v+1];

        int ans = 0;

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {

                int[] curr = dfs(i, adjList, visited);

                int nodes = curr[0];
                int edgeCount = curr[1] / 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}