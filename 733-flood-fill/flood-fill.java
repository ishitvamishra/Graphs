class Solution {
    int[] row = {-1, 0, 1, 0};
    int[] col = {0, 1, 0, -1};

    public void dfs(int[][] image, int r, int c, int n, int m, int start, int color){
        image[r][c] = color;

        for(int i = 0; i < 4; i++){
            int nr = row[i] + r;
            int nc = col[i] + c;

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == start && image[nr][nc] != color){
                dfs(image, nr, nc, n, m, start, color);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int start = image[sr][sc];

        dfs(image, sr, sc, n, m, start, color);

        return image;
    }
}