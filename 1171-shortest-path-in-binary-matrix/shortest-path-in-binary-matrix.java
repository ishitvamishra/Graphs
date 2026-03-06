class State{
    int row;
    int col;
    int dist;
    
    State(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

//Djisktra's Algorithm
class Solution {
    int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    int[] dy = {-1, 0,   1, 1, 1, 0,-1,-1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] != 0 || grid[n-1][m-1] != 0) return -1;

        if(n == 1 && grid[0][0] == 0) return 1;
        
        Queue<State> q = new LinkedList<>();
        
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)1e9;
            }
        }
        
        dist[0][0] = 0;
        q.add(new State(0, 0, 0));
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dist;
            q.remove();
            
            for(int i = 0; i < 8; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0 && dis + 1 < dist[nr][nc]){
                    dist[nr][nc] = dis + 1;
                    if(nr == n-1 && nc == m-1) return dist[nr][nc] + 1;
                    q.add(new State(nr, nc, dist[nr][nc]));
                }
            }
        }
        return -1;
    }
}
