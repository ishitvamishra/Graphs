class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min = nums[0];
        int max = nums[0];

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        for(int i = min; i < max; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }

        return res;
    }
}