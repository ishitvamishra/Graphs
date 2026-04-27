// User function Template for Java

class Solution {
    public List<String> allLCS(String s1, String s2) {
    int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Step 1: Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Backtracking with memo
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> result = solve(s1, s2, n, m, dp, memo);

        // Step 3: Sort
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private static Set<String> solve(String s1, String s2, int i, int j,
                                     int[][] dp,
                                     Map<String, Set<String>> memo) {

        String key = i + "#" + j;
        if (memo.containsKey(key)) return memo.get(key);

        Set<String> res = new HashSet<>();

        // Base case
        if (i == 0 || j == 0) {
            res.add("");
            return res;
        }

        // If characters match
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            Set<String> temp = solve(s1, s2, i - 1, j - 1, dp, memo);
            for (String str : temp) {
                res.add(str + s1.charAt(i - 1));
            }
        } else {
            // Move in valid directions
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                res.addAll(solve(s1, s2, i - 1, j, dp, memo));
            }
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                res.addAll(solve(s1, s2, i, j - 1, dp, memo));
            }
        }

        memo.put(key, res);
        return res;
    }
}