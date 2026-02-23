class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it : graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safe = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            safe.add(node);

            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        Collections.sort(safe);
        return safe;
    }
}