class Solution {
    int drow[] = {-1, 0, 1, 0};
    int dcol[] = {0, 1, 0, -1};

    public void dfs(int row, int col, int n, int m, int[][] vis, int[][] grid){
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                dfs(nr, nc, n, m, vis, grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++){

            if(grid[i][0] == 1 && vis[i][0] == 0){
                dfs(i, 0, n, m, vis, grid);
            }

            if(grid[i][m-1] == 1 && vis[i][m-1] == 0){
                dfs(i, m-1, n, m, vis, grid);
            }
        }

        for(int j = 0; j < m; j++){

            if(grid[0][j] == 1 && vis[0][j] == 0){
                dfs(0, j, n, m, vis, grid);
            }

            if(grid[n-1][j] == 1 && vis[n-1][j] == 0){
                dfs(n-1, j, n, m, vis, grid);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}