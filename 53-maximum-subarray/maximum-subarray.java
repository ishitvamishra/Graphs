class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}