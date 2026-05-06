class Solution {
    public int minCost(int n) {
        int dp[] = new int[n+1];

        Arrays.fill(dp, (int)1e9);
        dp[1] = 0;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + i - 1;
        }

        return dp[n];
    }
}