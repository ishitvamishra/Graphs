class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int sum = 0;

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) sum += nums[i];

        int lsum = 0;
        for(int i = 0; i < n; i++){
            lsum += nums[i];
            int rsum = sum - lsum;

            int val1 = Math.abs(nums[i] * (i+1) - lsum);
            int val2 = Math.abs(nums[i] * (n - i - 1) - rsum);

            ans[i] = Math.abs(val1 + val2);
        }

        return ans;
    }
}