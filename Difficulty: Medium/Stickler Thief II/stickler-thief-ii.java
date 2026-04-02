class Solution {
    public int maxValue(int[] nums) {
        // code here
        int n = nums.length;
        if(n==1) return nums[0];
        int[] sum1 = new int[n];
        int[] sum2 = new int[n];
        
        sum1[0] = nums[0];
        sum1[1] = Math.max(nums[0], nums[1]);
        sum2[0] = 0;
        sum2[1] = nums[1];
        for(int i = 2;i<n-1;i++){
            sum1[i] = Math.max(sum1[i-1], sum1[i-2]+nums[i]);
        }

        for(int i = 2;i<n;i++){
            sum2[i] = Math.max(sum2[i-1], sum2[i-2]+nums[i]);
        }
        
        return Math.max(sum1[n-2], sum2[n-1]);
    }
}
