class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    private void dfs(int r, int c, int n, int m, int oldColor, int newColor, int[][] image){
        image[r][c]  = newColor;
        
        for(int i = 0; i < 4; i++){
            int nr = r + dx[i];
            int nc = c + dy[i];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == oldColor){
                dfs(nr, nc, n, m, oldColor, newColor, image);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int oldColor = image[sr][sc];
        
        if(oldColor == newColor) return image;
        
        int n = image.length;
        int m = image[0].length;
        
        dfs(sr, sc, n, m, oldColor, newColor, image);
        return image;
    }
}