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

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    int shortestPath(int[][] grid, int[] src, int[] dest) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(src[0] == dest[0] && src[1] == dest[1]) return 0;
        
        Queue<State> q = new LinkedList<>();
        
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)1e9;
            }
        }
        
        dist[src[0]][src[1]] = 0;
        q.add(new State(src[0], src[1], 0));
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dist;
            q.remove();
            
            for(int i = 0; i < 4; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && dis + 1 < dist[nr][nc]){
                    dist[nr][nc] = dis + 1;
                    if(nr == dest[0] && nc == dest[1]) return dist[nr][nc];
                    q.add(new State(nr, nc, dist[nr][nc]));
                }
            }
        }
        return -1;
    }
}
