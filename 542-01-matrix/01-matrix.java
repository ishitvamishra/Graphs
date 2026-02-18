class Node{
    int row;
    int col;
    int steps;
    Node(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new Node(i, j, 0));
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            q.remove();
            ans[row][col] = steps;
            
            for(int i = 0; i < 4; i++){
                int nr = row + drow[i];
                int nc = col + dcol[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.add(new Node(nr, nc, steps+1));
                }
            }
        }
        return ans;
    }
}