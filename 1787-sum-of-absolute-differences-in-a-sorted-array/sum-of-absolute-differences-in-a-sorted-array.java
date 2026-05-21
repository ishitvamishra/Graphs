class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        // Build prefix sum
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Build suffix sum
        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        for(int i = 0; i < n; i++) {

            int leftSum = 0;
            int rightSum = 0;

            // Left contribution
            if(i > 0) {
                leftSum = nums[i] * i - prefix[i - 1];
            }

            // Right contribution
            if(i < n - 1) {
                rightSum = suffix[i + 1] - nums[i] * (n - i - 1);
            }

            ans[i] = leftSum + rightSum;
        }

        return ans;
    }
}