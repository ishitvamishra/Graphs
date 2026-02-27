class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int op = 0; op < k; op++){
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for(int i = 0;  i < nums.length; i++){
                if(nums[i] < min){
                    minIdx = i;
                    min = nums[i];
                }
            }

            nums[minIdx] = nums[minIdx]*multiplier;
        }
        return nums;
    }
}