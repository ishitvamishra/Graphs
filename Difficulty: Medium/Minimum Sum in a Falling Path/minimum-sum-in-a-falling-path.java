class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // code here
        int n = matrix.length;

        int[][] dp = new int[n][n];
        
        //since this problem follows variable starting point and ending point so  
        //we can fill from either bottom or top
        //Base condition is the first row if filling from top
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }

        //from i = 1 and j = 0; fill each cell by tracking their min src(left diag, up, right diag)
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                //assign then max value so if they are out of boundry it doesn't hinder min
                int ld = Integer.MAX_VALUE;
                int rd = Integer.MAX_VALUE;

                int up = matrix[i][j] + dp[i - 1][j];

                if(j - 1 >= 0) ld = matrix[i][j] + dp[i - 1][j - 1];

                if(j + 1 < n) rd = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            min = Math.min(min, dp[n-1][j]);
        }

        return min;
    }
}
