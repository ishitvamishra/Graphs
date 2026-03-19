class Solution {
    int maxOR = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        //find max OR
        for (int num : nums) {
            maxOR |= num;
        }

        dfs(nums, 0, 0);

        return count;
    }

    private void dfs(int[] nums, int index, int currOR) {
        // Base Case
        if (index == nums.length) {
            if (currOR == maxOR) count++;
            return;
        }

        //include current element
        dfs(nums, index + 1, currOR | nums[index]);

        //exclude current element
        dfs(nums, index + 1, currOR);
    }
}