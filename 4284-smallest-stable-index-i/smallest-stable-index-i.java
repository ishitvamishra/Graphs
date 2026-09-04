class Solution {
    public int firstStableIndex(int[] nums, int st) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int max = -1, min = Integer.MAX_VALUE;
            for(int j = 0; j <= i; j++){
                max = Math.max(nums[j], max);
            }

            for(int k = i; k<n; k++){
                min = Math.min(min, nums[k]);
            }

            if(max - min <= st){
                return i;
            }
        }

        return -1;
    }
}