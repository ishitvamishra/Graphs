class Solution {
    public void solve(int i, int j, int n, String path, ArrayList<String> ans, int[][] maze, int[][] vis, int[] di, int[] dj){
        if(i == n-1 && j == n-1){
            ans.add(path);
            return;
        }
        
        String dir = "DLRU";
        for(int ind = 0; ind < 4; ind++){
            int nexti = i+di[ind];
            int nextj = j+dj[ind];
            
            if(nexti >= 0 && nextj >= 0 && nexti<n && nextj <n && vis[nexti][nextj] ==0 && maze[nexti][nextj] == 1){
                vis[i][j] = 1;
                solve(nexti, nextj, n, path+dir.charAt(ind), ans, maze, vis, di, dj);
                vis[i][j] = 0;
            }
        }
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        int di[] = {+1, 0, 0, -1};
        int dj[] = {0, -1, 1, 0};
        
        if(maze[0][0] == 1) solve(0, 0, n, "", ans, maze, vis, di, dj);
        return ans;
    }
}