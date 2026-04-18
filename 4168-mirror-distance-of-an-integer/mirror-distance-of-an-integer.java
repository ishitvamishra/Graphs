class Solution {
    public int mirrorDistance(int n) {
        String reversed = new StringBuilder(String.valueOf(n))
                .reverse()
                .toString();

        int result = Integer.parseInt(reversed);
        return Math.abs(n - result);
    }
}