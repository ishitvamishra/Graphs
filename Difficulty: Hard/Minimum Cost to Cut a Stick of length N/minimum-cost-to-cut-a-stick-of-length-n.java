class Solution {
    public int minCutCost(int n, int[] cuts) {
        // code here
        int c = cuts.length;

        //adding 0, n to cuts
        int[] cut = new int[c+2];
        for (int i = 0; i < c; i++) {
            cut[i] = cuts[i];
        }   

        cut[c] = 0;
        cut[c+1] = n;

        //sort in order to avoid misplaced cuts
        Arrays.sort(cut);    

        int[][] dp = new int[c+2][c+2];

        for(int i = c; i >= 1; i--){
            for(int j = 1; j <= c; j++){
                if(i > j) continue;

                int min = Integer.MAX_VALUE;
                for(int ind = i; ind <= j; ind++){
                    //cost = len + left part + right part
                    int cost = cut[j+1] - cut[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][c];
    }
}
