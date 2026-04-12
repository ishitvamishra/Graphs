class Solution {
    int[][] pos = new int[26][2];
    Integer[][][] dp;

    public int minimumDistance(String word) {
        // Precompute positions
        for(int i = 0; i < 26; i++){
            pos[i][0] = i / 6;
            pos[i][1] = i % 6;
        }

        int n = word.length();
        dp = new Integer[n][27][27];

        return solve(word, 0, 26, 26); // 26 = no finger placed yet
    }

    private int solve(String word, int i, int f1, int f2){
        if(i == word.length()) return 0;

        if(dp[i][f1][f2] != null) return dp[i][f1][f2];

        int curr = word.charAt(i) - 'A';

        // move finger1
        int cost1 = (f1 == 26) ? 0 : dist(f1, curr);
        cost1 += solve(word, i + 1, curr, f2);

        // move finger2
        int cost2 = (f2 == 26) ? 0 : dist(f2, curr);
        cost2 += solve(word, i + 1, f1, curr);

        return dp[i][f1][f2] = Math.min(cost1, cost2);
    }

    private int dist(int a, int b){
        return Math.abs(pos[a][0] - pos[b][0]) +
               Math.abs(pos[a][1] - pos[b][1]);
    }
}