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
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        dfs(i, j, n, m, vis, grid);
                    }
                }
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