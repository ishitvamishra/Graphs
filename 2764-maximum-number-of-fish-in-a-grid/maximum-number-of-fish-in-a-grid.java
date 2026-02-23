class Solution {
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};
    public int dfs(int row, int col, int n, int m, int[][] grid){
        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0) {
            return 0;
        }

        int fish = grid[row][col];

        grid[row][col] = 0;

        for(int i = 0; i < 4; i++){
            int nr = row + dx[i];
            int nc = col + dy[i];

            fish += dfs(nr, nc, n, m, grid);
        }
        return fish;
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxFish = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] > 0){
                    int currFish = dfs(i, j, n, m, grid);
                    maxFish = Math.max(maxFish, currFish);
                }
            }
        }
        return maxFish;
    }
}