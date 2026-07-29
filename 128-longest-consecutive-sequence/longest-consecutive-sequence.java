class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        
        int ans = 0;
        for (int num : set) {

            // Start only if num is the first element
            if (!set.contains(num - 1)) {

                int curr = num;
                int len = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                ans = Math.max(ans, len);
            }
        }
        
        return ans;
    }
}