class Solution {
    int drow[] = {-1, 0, 1, 0};
    int dcol[] = {0, 1, 0, -1};
    private void dfs(int row, int col, int[][] copy, int[][] image, int oldColor, int color){
        copy[row][col] = color;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i<4; i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];
            if(nr >= 0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == oldColor && copy[nr][nc] != color){
                dfs(nr, nc, copy, image, oldColor, color);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int[][] copy = image;
        dfs(sr, sc, copy, image, oldColor, color);
        return copy;
    }
}