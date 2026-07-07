class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int longIncPath(int[][] matrix, int n, int m) {
        // Code here
        int[][] dp = new int[n][m];
        int ans = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dfs(i, j, matrix, dp));
            }
        }
        
        return ans;
    }
    
    public int dfs(int r, int c, int[][] matrix, int[][] dp){
        if(dp[r][c] != 0) return dp[r][c];
        
        int best = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int k = 0; k < 4; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[r][c]){
                best = Math.max(best, 1 + dfs(nr, nc, matrix, dp));
            }
        }
        
        dp[r][c] = best;
        return best;
    }
}