class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int len = nums.length;

        int[] pehleMax = new int[len];
        int[] baadMin = new int[len];

        pehleMax[0] = nums[0];

        for(int i = 1; i < len; i++){
            pehleMax[i] = Math.max(pehleMax[i-1], nums[i]);
        }

        baadMin[len - 1] = nums[len - 1];
        for(int i = len - 2; i >= 0; i--){
            baadMin[i] = Math.min(baadMin[i + 1], nums[i]);
        }

        for(int i = 0; i < len; i++){
            if(pehleMax[i] - baadMin[i] <= k){
                return i;
            }
        }
        return -1;
    }
}