class Solution {
    public int minCost(int n) {
        int[] dp = new int[n+1];

        Arrays.fill(dp, (int)1e9);
        
        dp[1] = 0;
        

        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                int cost = dp[j] + dp[i - j] + j*(i-j);
                dp[i] = Math.min(dp[i], cost);
            }
        }

        return dp[n];
    }
}