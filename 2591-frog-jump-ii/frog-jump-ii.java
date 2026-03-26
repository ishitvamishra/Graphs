class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int maxi = Integer.MIN_VALUE;
        if (n == 2)
            return stones[n - 1] - stones[0];
        for (int i = 0; i < n - 2; i++) {
            // finding difference b/w alternate stone positions
            // max cost found is the min cost of the path
            maxi = Math.max(maxi, stones[i + 2] - stones[i]);
        }
        return maxi;
    }
}