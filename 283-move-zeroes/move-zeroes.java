class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;

        while(i < n && j < n){
            if(nums[i] == 0 && nums[j] == 0){
                j++;
            }

            else if(nums[i] == 0 && nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++;
                j++;
            }

            else{
                i++;
                j++;
            }
        }
    }
}