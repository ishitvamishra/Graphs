class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        
        // Precompute coordinates
        int[][] pos = new int[26][2];
        for(int i = 0; i < 26; i++){
            pos[i][0] = i / 6;
            pos[i][1] = i % 6;
        }

        // Distance function
        java.util.function.BiFunction<Integer, Integer, Integer> dist = (a, b) -> {
            return Math.abs(pos[a][0] - pos[b][0]) + Math.abs(pos[a][1] - pos[b][1]);
        };

        int total = 0;
        int[] dp = new int[26]; // max saving

        for(int i = 1; i < n; i++){
            int prev = word.charAt(i - 1) - 'A';
            int curr = word.charAt(i) - 'A';

            int d = dist.apply(prev, curr);
            total += d;

            int[] newDp = new int[26];

            for(int c = 0; c < 26; c++){
                // option 1: don't use second finger
                newDp[c] = Math.max(newDp[c], dp[c]);

                // option 2: use second finger (move from c → curr)
                int gain = d - dist.apply(c, curr);
                newDp[prev] = Math.max(newDp[prev], dp[c] + gain);
            }

            dp = newDp;
        }

        int maxSaved = 0;
        for(int val : dp) maxSaved = Math.max(maxSaved, val);

        return total - maxSaved;
    }
}