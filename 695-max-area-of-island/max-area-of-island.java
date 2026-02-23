class Solution {
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};
    public int dfs(int[][] grid, int row, int col, int n, int m) {
        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int area = 1;  

        for(int i = 0; i < 4; i++){
            int nr = row + dx[i];
            int nc = col + dy[i];

            area += dfs(grid, nr, nc, n, m);
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfs(grid, i, j, n, m);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }
}