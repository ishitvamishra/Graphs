class Solution {
    public int minElement(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = digitSum(nums[i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
        }

        return min;
    }

    public int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}