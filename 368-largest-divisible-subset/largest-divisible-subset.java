class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = i;
        }

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct LDS
        ArrayList<Integer> lis = new ArrayList<>();
        while (parent[lastIndex] != lastIndex) {
            lis.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        lis.add(nums[lastIndex]);

        // reverse because we built it backwards
        Collections.reverse(lis);
        return lis;
    }
}