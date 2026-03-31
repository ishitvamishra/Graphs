class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // Step 1: XOR of all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Get rightmost set bit
        int mask = xor & (-xor);

        int a = 0, b = 0;

        // Step 3: Divide into two groups
        for (int num : nums) {
            if ((num & mask) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}