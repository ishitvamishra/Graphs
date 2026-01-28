class Solution {

    public void DFS(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 'W') {
            return;
        }

        // mark visited
        grid[i][j] = 'W';

        DFS(grid, i + 1, j, row, col);
        DFS(grid, i - 1, j, row, col);
        DFS(grid, i, j + 1, row, col);
        DFS(grid, i, j - 1, row, col);

        DFS(grid, i + 1, j + 1, row, col);
        DFS(grid, i - 1, j - 1, row, col);
        DFS(grid, i + 1, j - 1, row, col);
        DFS(grid, i - 1, j + 1, row, col);
    }

    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') {
                    count++;
                    DFS(grid, i, j, n, m);
                }
            }
        }

        return count;
    }
}
