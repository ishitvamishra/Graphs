class Solution {
    public int minDifference(int nums[]) {
        // code here
        int n = nums.length;
        int totSum = 0;
        for(int num : nums) totSum+= num;

        boolean[][] dp = new boolean[n][totSum + 1];

        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(nums[0] <= totSum) dp[0][nums[0]] = true;

        for(int ind = 1; ind < n; ind++){
            for(int target = 1; target <= totSum; target++){
                boolean notTake = dp[ind - 1][target];
                boolean take = false;
                if(target >= nums[ind]) take = dp[ind - 1][target - nums[ind]];

                dp[ind][target] = take || notTake;
            }
        }

        int mini = (int)1e9;
        for(int i = 0; i <= totSum/2; i++){
            if(dp[n-1][i] == true){
                int s1 = i;
                int s2 = totSum - i;
                mini = Math.min(mini,Math.abs(s1 - s2));
            }
        }

        return mini;
    }
}
