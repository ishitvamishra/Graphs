class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        //states : row, col, cost
        int[][][] dp = new int[m][n][k + 1];

        // initialize with -1 (unreachable)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = grid[i][j];
                int cost = (val == 0) ? 0 : 1;
                int score = val;

                for (int c = 0; c <= k; c++) {
                    if (c - cost < 0) continue;

                    int best = -1;

                    // coming from top
                    if (i > 0 && dp[i - 1][j][c - cost] != -1) {
                        best = Math.max(best, dp[i - 1][j][c - cost]);
                    }

                    // coming from left
                    if (j > 0 && dp[i][j - 1][c - cost] != -1) {
                        best = Math.max(best, dp[i][j - 1][c - cost]);
                    }

                    // start cell
                    if (i == 0 && j == 0 && c == 0) {
                        best = 0;
                    }

                    if (best != -1) {
                        dp[i][j][c] = best + score;
                    }
                }
            }
        }

        // finding best cost
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans;
    }
}