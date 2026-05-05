class Solution {
    public int numberofLIS(int nums[]) {
        // Code here
        int n = nums.length;

        int[] dp = new int[n];
        int[] cnt = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            cnt[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){

                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }
        }

        int max = 0; 
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }

        int sum =  0;
        for(int i = 0; i < n; i++){
            if(dp[i] == max) sum += cnt[i];
        }

        return sum;
    }
}