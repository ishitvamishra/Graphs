class Solution {
    public boolean isGood(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (nums.length != max + 1) return false;

        for (int i = 1; i < max; i++) {
            if (map.getOrDefault(i, 0) != 1) {
                return false;
            }
        }

        return map.getOrDefault(max, 0) == 2;
    }
}