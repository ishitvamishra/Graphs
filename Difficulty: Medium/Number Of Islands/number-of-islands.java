// User function Template for Java

class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {

        int[][] grid = new int[n][m];
        List<Integer> result = new ArrayList<>();

        for (int op = 0; op < operators.length; op++) {

            int row = operators[op][0];
            int col = operators[op][1];

            // If already land, just repeat last count
            if (grid[row][col] == 1) {
                if (op == 0) result.add(0);
                else result.add(result.get(op - 1));
                continue;
            }

            grid[row][col] = 1;

            boolean[][] visited = new boolean[n][m];
            int count = 0;

            // Count islands using DFS
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (grid[i][j] == 1 && !visited[i][j]) {
                        dfs(grid, visited, i, j, n, m);
                        count++;
                    }
                }
            }

            result.add(count);
        }

        return result;
    }

    private void dfs(int[][] grid, boolean[][] visited,
                     int row, int col, int n, int m) {

        visited[row][col] = true;

        for (int k = 0; k < 4; k++) {

            int nr = row + dr[k];
            int nc = col + dc[k];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                grid[nr][nc] == 1 &&
                !visited[nr][nc]) {

                dfs(grid, visited, nr, nc, n, m);
            }
        }
    }
}