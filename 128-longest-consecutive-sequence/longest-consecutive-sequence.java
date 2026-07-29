class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;
        for(int num : set){
            int len = 0;

            if(!set.contains(num + 1)){
                while(set.contains(num--)){
                    len++; 
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}