class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, end = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;

        while(end < n){
            while(end < n && sum < target){
                sum += nums[end++];
            }
            while(start < n && sum >= target){
                minLen = Math.min(minLen, end - start);
                sum -= nums[start++];
            }
        }

        return  minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}