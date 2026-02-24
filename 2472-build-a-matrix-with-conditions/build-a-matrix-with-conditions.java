class Solution {
    private ArrayList<Integer> topoSort(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V + 1];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        if(topo.size() != V) return new ArrayList<>();
        return topo;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        ArrayList<Integer> rowOrder = topoSort(k, rowConditions);
        if(rowOrder.size() == 0) return new int[0][0];

        ArrayList<Integer> colOrder = topoSort(k, colConditions);
        if(colOrder.size() == 0) return new int[0][0];

        int[][] matrix = new int[k][k];

        int rowPos[] = new int[k+1];
        int colPos[] = new int[k+1];

        for(int i = 0; i < k; i++){
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }

        for(int num = 1; num <= k; num++){
            matrix[rowPos[num]][colPos[num]] = num;
        }

        return matrix;
    }
}