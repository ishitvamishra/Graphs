class Solution {
    int drow[] = {-1, 0, 1, 0};
    int dcol[] = {0, 1, 0, -1};
    public int dfs(int row, int col, int n, int m, int[][] grid){

        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0) return 1;

        if(grid[row][col] == -1) return 0;

        grid[row][col] = -1;

        int p = 0;
        for(int i = 0; i < 4; i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];

            p += dfs(nr, nc, n, m, grid);
        }
        return p;
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int p =0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    p += dfs(i, j, n, m, grid);
                }
            }
        }
        return p;
    }
}