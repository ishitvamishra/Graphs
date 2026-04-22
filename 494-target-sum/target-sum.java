class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar + 1];

        // Base case
        if (num[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (num[0] != 0 && num[0] <= tar) {
            dp[0][num[0]] = 1;
        }

        for(int ind = 1; ind < n; ind++){
            for(int sum = 0; sum <= tar; sum++){
                int notTake = dp[ind - 1][sum];
                int take = 0;

                if(num[ind] <= sum){
                    take = dp[ind - 1][sum - num[ind]];
                }

                dp[ind][sum] = (take + notTake);
            }
        }

        return dp[n-1][tar];
    }
    public int findTargetSumWays(int[] nums, int d) {
        int totSum = 0;

        for(int it : nums) totSum += it;

        if(totSum - d < 0 || (totSum - d) % 2 != 0) return 0;

        return findWays(nums, (totSum - d) / 2);
    }
}