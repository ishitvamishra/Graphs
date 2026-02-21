class Solution {
    int drow[] = {-1, 0, 1, 0};
    int dcol[] = {0, 1, 0, -1};
    public boolean dfs(int[][] grid1, int[][] grid2, int row, int col, int n, int m){
        grid2[row][col] = 0;
        boolean isSub = true;

        if(grid1[row][col] == 0){
            isSub = false;
        }

        for(int i = 0; i < 4; i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid2[nr][nc] == 1){
                isSub = dfs(grid1, grid2, nr, nc, n, m) && isSub; 
            }
        }
        return isSub;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    if(dfs(grid1, grid2, i, j, n, m)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}