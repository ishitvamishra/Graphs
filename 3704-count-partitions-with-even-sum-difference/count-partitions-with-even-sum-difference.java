class Solution {
    public int countPartitions(int[] nums) {
        int totSum =  0;
        int n = nums.length;
        for(int num : nums) totSum += num;

        if(totSum % 2 == 0) return n - 1;
        
        return 0;
    }
}