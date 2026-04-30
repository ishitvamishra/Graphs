class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int n = prices.length;

        int[][] dp = new int[n+1][5];

        for(int ind = n-1 ; ind >= 0; ind--){
            for(int tr = 0; tr < 4; tr++){  
                int profit = 0;

                // buy
                if(tr % 2 == 0)
                    profit = Math.max(-prices[ind] + dp[ind+1][tr+1], dp[ind+1][tr]);

                // sell
                else
                    profit = Math.max(prices[ind] + dp[ind+1][tr+1], dp[ind+1][tr]);

                dp[ind][tr] = profit;
            }
        }
        return dp[0][0];
    }
}
