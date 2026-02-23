class Solution {
    public ArrayList<Integer> findOrder(int V, int[][] edges) {
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
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            //for each node add to ans, reduce the indegree of all its neighbouring nodes
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        //if course cannot be completed or graph is cyclic 
        if(topo.size() != V) return new ArrayList<>();

        return topo;
    }
}