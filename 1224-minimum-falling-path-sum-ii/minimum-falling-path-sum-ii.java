class Solution {
    public int minFallingPathSum(int[][] matrix) {
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
                int prevMin = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(k != j){
                        prevMin = Math.min(prevMin, matrix[i][j] + dp[i - 1][k]);
                    }
                }


                dp[i][j] = prevMin;
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++){
            min = Math.min(min, dp[n-1][j]);
        }

        return min;
    }
}