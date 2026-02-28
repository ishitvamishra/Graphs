//using topological sort bhi hojayega 
class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int maxCycle = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            HashMap<Integer, Integer> map = new HashMap<>();
            int node = i;
            int step = 0;

            while (node != -1 && !visited[node]) {

                visited[node] = true;
                map.put(node, step++);
                node = edges[node];

                if (node != -1 && map.containsKey(node)) {
                    int cycleLength = step - map.get(node);
                    maxCycle = Math.max(maxCycle, cycleLength);
                    break;
                }
            }
        }

        return maxCycle;
    }
}