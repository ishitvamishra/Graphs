class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= firstMin) firstMin = nums[i]; //first smallest

            else if(nums[i] <= secondMin) secondMin = nums[i];  //second smallest

            else  return true; //third element
        }
        return false;
    }
}