class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int fresh = 0;
        
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(mat[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(mat[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        int tm = 0;
        int cnt= 0;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, 0, -1};
        
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            
            tm = Math.max(tm, t);
            q.remove();
            
            for(int i = 0; i < 4; i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];
                
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && vis[nr][nc] == 0 && mat[nr][nc] == 1){
                    q.add(new Pair(nr, nc, t+1));
                    vis[nr][nc] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != fresh) return -1;
        return tm;
    }
}