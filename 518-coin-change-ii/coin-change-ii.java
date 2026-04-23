class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp  =  new int[n][amount + 1];

        for(int i = 0; i <= amount; i++){
            dp[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for(int ind = 1; ind < n; ind++){
            for(int amt = 0; amt <= amount; amt++){
                int notTake = dp[ind - 1][amt];
                int take = 0;
                if(coins[ind] <= amt) take = dp[ind][amt - coins[ind]]; //take wale condition me bhi same
                //  index pe rehna ha until  take ki condition fail nhi hoti h

                dp[ind][amt] = take  + notTake;
            }
        }

        return dp[n - 1][amount];
    }
}

// 1D optimization
// class Solution {
//     public int change(int amount, int[] coins) {
//         int[] dp = new int[amount + 1];
//         dp[0] = 1; //mmaking  amt = 0, only 1 way

//         for (int coin : coins) {
//             for (int amt = coin; amt <= amount; amt++) {
//                 dp[amt] += dp[amt - coin];
//             }
//         }

//         return dp[amount];
//     }
// }