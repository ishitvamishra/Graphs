class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int INF = (int)1e9;

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = INF;
            }
        }

        // Base case: 0 walls → cost 0
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {

                //Not take
                dp[i][j] = dp[i-1][j];

                //Take
                int covered = time[i-1] + 1;
                int prev = Math.max(0, j - covered);

                dp[i][j] = Math.min(dp[i][j], cost[i-1] + dp[i-1][prev]);
            }
        }

        return dp[n][n];
    }
}