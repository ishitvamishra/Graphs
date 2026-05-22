class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] zeros = new int[n];

        for(int[] query : queries){
            int l = query[0];
            int r = query[1];

            zeros[l]++;
            
            if(r + 1 < n){
                zeros[r+1]--;
            }
        }

        for(int i = 1; i < n; i++){
            zeros[i] += zeros[i-1];
        }

        for(int i = 0; i < n; i++){
            if(nums[i] >= zeros[i]){
                nums[i] = nums[i] - zeros[i];
                if(nums[i] > 0 ) return false;
            }
        }

        return true;
    }
}