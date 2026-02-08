// User function Template for Java

class Solution {
    static int palPartition(String s) {
        // code here
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) &&
                   (j - i <= 2 || isPal[i+1][j-1])){
                    isPal[i][j] = true;
                }
            }
        }

        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            if(isPal[0][i]){
                dp[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < i; j++){
                    if(isPal[j+1][i]){
                        min = Math.min(min, dp[j] + 1);
                    }
                }
                dp[i] = min;
            }
        }

        return dp[n-1];
    }
}