class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, cnt =  0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                cnt++;
            } else{
                cnt = 0;
            }

            maxCount = Math.max(maxCount, cnt);
        }

        return maxCount;
    }
}