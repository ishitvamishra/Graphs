class Solution {

    // DFS returns area of current region
    public int DFS(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int area = 1;  

        area += DFS(grid, i + 1, j, row, col);
        area += DFS(grid, i - 1, j, row, col);
        area += DFS(grid, i, j + 1, row, col);
        area += DFS(grid, i, j - 1, row, col);

        area += DFS(grid, i + 1, j + 1, row, col);
        area += DFS(grid, i - 1, j - 1, row, col);
        area += DFS(grid, i + 1, j - 1, row, col);
        area += DFS(grid, i - 1, j + 1, row, col);

        return area;
    }

    public int findMaxArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int currArea = DFS(grid, i, j, n, m);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }
}
