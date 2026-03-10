class State{
    int row;
    int col;
    int obs;

    State(int row, int col, int obs){
        this.row = row;
        this.col = col;
        this.obs = obs;
    }
}

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        if(k >= n + m - 2) return n + m - 2; //if obstacle to be removed are greater than normal shortest path

        Queue<State> q = new LinkedList<>();
        boolean[][][] vis = new boolean[n][m][k+1]; //row, col, obs ke liye respectively

        q.add(new State(0,0,0));
        vis[0][0][0] = true;

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int row = q.peek().row;
                int col = q.peek().col;
                int obs = q.peek().obs;
                q.remove();

                if(row == n-1 && col == m-1) return steps;

                for(int d = 0; d < 4; d++){
                    int nr = row + dx[d];
                    int nc = col + dy[d];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                    int newObs = obs + grid[nr][nc];

                    if(newObs <= k && !vis[nr][nc][newObs]){
                        vis[nr][nc][newObs] = true;
                        q.add(new State(nr, nc, newObs));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}