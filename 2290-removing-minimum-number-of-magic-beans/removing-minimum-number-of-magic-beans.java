class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);

        long total = 0;

        for(int x : beans) total += x;

        long ans = Long.MAX_VALUE;

        int n = beans.length;

        for(int i = 0; i < n; i++) {

            long keep = 1L * beans[i] * (n - i);

            long remove = total - keep;

            ans = Math.min(ans, remove);
        }

        return ans;
    }
}