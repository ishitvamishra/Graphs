class Solution {
    public int[] transformArray(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0){
                res[i] = 1;
            }
        }

        Arrays.sort(res);
        return res;
    }
}