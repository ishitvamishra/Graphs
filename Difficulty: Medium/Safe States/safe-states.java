class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }
        
        int[] indegree = new int[V];
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            adjRev.get(v).add(u);
            indegree[u]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safe = new ArrayList<>();
        for(int i = 0; i < V;i++){
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