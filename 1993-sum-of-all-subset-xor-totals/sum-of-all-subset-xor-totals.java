class Solution {

    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currXor) {
        // Base case
        if (index == nums.length) {
            return currXor;
        }

        //include current element
        int include = dfs(nums, index + 1, currXor ^ nums[index]);

        //exclude current element
        int exclude = dfs(nums, index + 1, currXor);

        return include + exclude;
    }
}