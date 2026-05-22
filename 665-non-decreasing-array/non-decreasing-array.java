class Solution {
    public boolean checkPossibility(int[] nums) {
        int changes = 0;

        for(int i = 0; i < nums.length - 1; i++) {

            if(nums[i] > nums[i + 1]) {

                changes++;

                if(changes > 1) return false;

                // modify nums[i]
                if(i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                }

                // modify nums[i+1]
                else {
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }
}