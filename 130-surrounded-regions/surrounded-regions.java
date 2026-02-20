class Solution {
    int drow[] = {-1,0,1,0};
    int dcol[] = {0,1,0,-1};

    public void dfs(int row, int col, int n, int m, int[][] vis, char[][] board){
        vis[row][col] = 1;
        
        for(int i = 0; i < 4; i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && board[nr][nc] == 'O'){
                dfs(nr, nc, n, m, vis, board);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];

        //check 0's in first first col and last col
        for(int i = 0; i < n; i++){
            //first col
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, n, m, vis, board);
            }
            //last col
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1, n, m, vis, board);
            }
        }

        //check 0's in first row and last row
        for(int j = 0; j < m; j++){
            //first row
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, n, m, vis, board);
            }
            //last row
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1, j, n, m, vis, board);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}