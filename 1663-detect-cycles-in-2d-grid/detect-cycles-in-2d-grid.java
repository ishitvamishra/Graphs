class Solution {
    int drow[] = {-1, 0, 1, 0};
    int dcol[] = {0, 1, 0, -1};

    private boolean dfs(int r, int c, int pr, int pc, boolean[][] vis, char[][] grid, char ch, int n, int m){
        vis[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r + drow[i];
            int nc = c + dcol[i];

            if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

            if(grid[nr][nc] != ch) continue;

            if(!vis[nr][nc]){
                if(dfs(nr, nc, r, c, vis, grid, ch, n, m)){
                    return true;
                }
            }
            //agar visited h aur next row aur next col parent row aur parent col ke barabar nhi h 
            //yani cycle found toh return krdo true;
            else if(nr != pr || nc != pc){
                return true;
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(!vis[i][j]){
                    if(dfs(i, j, -1, -1, vis, grid, grid[i][j], n, m)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}