class Solution {

    boolean graphColoring(int v, int[][] edges, int m) {
        
        boolean[][] graph = new boolean[v][v];

        // build adjacency matrix from edges
        for(int[] e : edges){
            int u = e[0];
            int w = e[1];
            graph[u][w] = true;
            graph[w][u] = true;
        }

        int[] color = new int[v];
        return solve(0, graph, m, v, color);
    }

    boolean solve(int node, boolean[][] graph, int m, int v, int[] color){

        if(node == v)
            return true;

        for(int c = 1; c <= m; c++){

            if(isSafe(node, graph, color, c, v)){
                color[node] = c;

                if(solve(node + 1, graph, m, v, color))
                    return true;

                color[node] = 0;
            }
        }

        return false;
    }

    boolean isSafe(int node, boolean[][] graph, int[] color, int c, int v){
        for(int i = 0; i < v; i++){
            if(graph[node][i] && color[i] == c)
                return false;
        }
        return true;
    }
}
