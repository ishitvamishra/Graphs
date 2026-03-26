class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;

        for(int num : nums){
            total+=num;
        }

        int left=0;
        int[] result = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            total-=nums[i];
            result[i] = Math.abs(left-total);
            left+=nums[i];
        }
        
        return result;
    }
}