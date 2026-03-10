class State{
    int node;
    int mask;

    State(int node, int mask){
        this.node = node;
        this.mask = mask;
    }
}

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int targetMask = (1 << n) - 1;

        Queue<State> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][1 << n];

        for(int i = 0; i < n; i++){
            int mask = (1 << i);
            q.add(new State(i, mask));
            vis[i][mask] = true;
        }

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int node = q.peek().node;
                int mask = q.peek().mask;
                q.remove();

                if(mask == targetMask) return steps;

                for(int next : graph[node]){
                    int newMask = mask | (1 << next);

                    if(!vis[next][newMask]){
                        vis[next][newMask] = true;
                        q.add(new State(next, newMask));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}