class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digSum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            int digit = nums[i];

            while(digit > 0){
                digSum += digit % 10;
                digit /= 10;
            }
        }

        return Math.abs(sum - digSum);
    }
}