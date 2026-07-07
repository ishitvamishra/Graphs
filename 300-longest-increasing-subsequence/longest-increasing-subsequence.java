class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] temp = new int[n];
    //     int len = 0;

    //     for (int num : nums) {
    //         int low = 0, high = len - 1;
    //         while (low <= high) {
    //             int mid = low + (high - low) / 2;
    //             if (temp[mid] < num)
    //                 low = mid + 1;
    //             else
    //                 high = mid - 1;
    //         }
    //         temp[low] = num;
    //         if (low == len) len++;
    //     }

    //     return len;
    // }
    

//------------------------------------DP SOLUTION || TC - O(N*N)----------------------------------
    // this method gives tle as well but usefull in printing the lis

     public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Har element khud me ek LIS hai of length 1  
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Agar increasing hai to extend kar sakte hain
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}