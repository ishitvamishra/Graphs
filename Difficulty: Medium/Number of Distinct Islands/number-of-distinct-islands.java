import java.util.*;

class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == 1 && !vis[i][j]){

                    List<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, grid, vis, shape);

                    set.add(shape);
                }
            }
        }

        return set.size();
    }

    private void dfs(int r, int c, int baseR, int baseC,
                     int[][] grid, boolean[][] vis,
                     List<String> shape){

        int n = grid.length;
        int m = grid[0].length;

        vis[r][c] = true;

        // Store relative position
        shape.add((r - baseR) + "," + (c - baseC));

        for(int k = 0; k < 4; k++){

            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr >= 0 && nc >= 0 && nr < n && nc < m &&
               grid[nr][nc] == 1 && !vis[nr][nc]){

                dfs(nr, nc, baseR, baseC, grid, vis, shape);
            }
        }
    }
}