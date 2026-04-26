class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        if (n == 1) {
            res.add(nums[0]);
            return res;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Build leftMax
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }

        // Build rightMax
        rightMax[n - 1] = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
        }

        // Check valid elements
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1 || nums[i] > leftMax[i] || nums[i] > rightMax[i]) {
                res.add(nums[i]);
            }
        }

        return res;

    }
}