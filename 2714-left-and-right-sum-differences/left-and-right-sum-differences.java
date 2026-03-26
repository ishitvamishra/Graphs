class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int leftSum = 0, rightSum = 0;

            if(i == 0) leftSum = 0;

            if(i == n - 1) rightSum = 0;

            for(int r =  i + 1; r < n; r++){
                rightSum += nums[r];
            }

            for(int l = 0; l < i; l++){
                leftSum += nums[l];
            }

            res[i] =  Math.abs(leftSum -  rightSum);
        }

        return res;
    }
}