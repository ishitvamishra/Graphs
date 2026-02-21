class Solution {
    int drow[] = {-1, 0, 1, 0};
    int dcol[] = {0, 1, 0, -1};

    public int[][] findFarmland(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        
        List<int[]> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(land[i][j] == 1){
                    int[] bounds = new int[]{i, j, i, j};

                    dfs(land, i, j, n, m, bounds);
                    
                    result.add(new int[]{bounds[0],bounds[1],bounds[2],bounds[3]});
                }
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    private void dfs(int[][] land, int r, int c, int n, int m, int[] bounds){
        
        if(r < 0 || c < 0 || r >= n || c >= m || land[r][c] == 0)
            return;
        
        // mark visited
        land[r][c] = 0;
        
        // update boundaries
        bounds[0] = Math.min(bounds[0], r);
        bounds[1] = Math.min(bounds[1], c);
        bounds[2] = Math.max(bounds[2], r);
        bounds[3] = Math.max(bounds[3], c);
        
        // explore 4 directions
        for(int i = 0; i < 4; i++){
            int nr = r + drow[i];
            int nc = c + dcol[i];
            dfs(land, nr, nc, n, m, bounds);
        }
    }
}