class Solution {
    public int findMin(int W) {
        // code here
        int[] wt = {1,2,5,10};
        int n = wt.length;
        int dp[][] = new int[n+1][W+1];

        int INF = (int)1e9;
        for(int i = 0;i<=W;i++){
            dp[0][i] = INF;
        }
    
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=W;j++){
                if(j<wt[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j - wt[i-1]]);
                }
            }
        }
        if(dp[n][W] >= INF){
            return -1;
        }
        
        return dp[n][W];
    }
}
