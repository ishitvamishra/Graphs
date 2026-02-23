class Solution {
    public boolean canFinish(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        //Build Adj List
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            //to take u you need to complete v first so v -> u
            adj.get(v).add(u);
        }

        //Calculate indegree of each vertex
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int it :  adj.get(i)){
                indegree[it]++;
            }
        }

        //add all element whose initial indegree is 0
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        //Build topo array
        int[] topo = new int[V];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;

            //for each node add to ans, reduce the indegree of all its neighbouring nodes
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return i == V;
    }
}