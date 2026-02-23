class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    private void dfs(int row, int col, int n, int m,
                     int orgCol, boolean[][] vis, int[][] grid){
        
        vis[row][col] = true;

        boolean isBorder = false;

        for(int i = 0; i < 4; i++){
            int nr = row + dx[i];
            int nc = col + dy[i];

            if(nr < 0 || nr >= n || nc < 0 || nc >= m){
                isBorder = true;
            }
            else if(Math.abs(grid[nr][nc]) != orgCol){
                isBorder = true;
            }
            else if(!vis[nr][nc]){
                dfs(nr, nc, n, m, orgCol, vis, grid);
            }
        }

        if(isBorder){
            grid[row][col] = -orgCol;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int orgCol = grid[row][col];

        dfs(row, col, n, m, orgCol, vis, grid);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == -orgCol){
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }
}