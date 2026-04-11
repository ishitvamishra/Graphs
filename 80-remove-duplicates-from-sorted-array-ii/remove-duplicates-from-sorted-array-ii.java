class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int cons = 1; // count current duplicates
        int k = 1;    // position to place next valid element

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                cons++;
            } else {
                cons = 1;
            }

            if(cons <= 2){
                nums[k++] = nums[i]; // inplace overwrite
            }
        }

        return k;
    }
}