class Solution {
    public int maximumScore(int[] nums, int k) {

        int n = nums.length;

        int l = k;
        int r = k;

        int min = nums[k];
        int ans = min;

        while (l > 0 || r < n - 1) {

            if (l == 0) {
                r++;
                min = Math.min(min, nums[r]);
            }
            else if (r == n - 1) {
                l--;
                min = Math.min(min, nums[l]);
            }
            else if (nums[l - 1] < nums[r + 1]) {
                r++;
                min = Math.min(min, nums[r]);
            }
            else {
                l--;
                min = Math.min(min, nums[l]);
            }

            ans = Math.max(ans, min * (r - l + 1));
        }

        return ans;
    }
}