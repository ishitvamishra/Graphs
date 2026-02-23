class Solution {
    int[] drow = {-1,0,1,0};
    int[] dcol = {0,1,0,-1};

    public boolean dfs(int row, int col, boolean[][] vis, int[][] grid, int n, int m){
        //out of boundary ho ya first row first col last row last col me ho
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return false;
        }

        // If water or already visited → doesn't affect closed property
        if (grid[row][col] == 1 || vis[row][col]) {
            return true;
        }

        vis[row][col] = true;

        boolean isClosed = true;

        for (int i = 0; i < 4; i++) {
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if (!dfs(nr, nc, vis, grid, n, m)) {
                isClosed = false;
            }
        }
        return isClosed;
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && !vis[i][j] ){
                    if(dfs(i, j, vis, grid, n, m)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}