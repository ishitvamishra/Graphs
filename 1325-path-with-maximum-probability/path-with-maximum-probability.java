class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] prob = new double[n];
        prob[start_node] = 1;

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                double p = succProb[j];

                if(prob[u] * p > prob[v]){
                    prob[v] = prob[u] * p;
                }

                if(prob[v] * p > prob[u]){
                    prob[u] = prob[v] * p;
                }
            }
        }

        return prob[end_node];
    }
}