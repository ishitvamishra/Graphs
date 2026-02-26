class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};

    private boolean dfs(int row, int col, int idx, int n, int m, char[][] board, String word){
        if(idx == word.length()) return true;

        if(row < 0 || row >= n || col < 0 || col >= m || board[row][col] != word.charAt(idx)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '*';

        for(int i = 0; i< 4; i++){
            int nr = row + dx[i];
            int nc = col + dy[i];

            if(dfs(nr, nc , idx+1, n,m, board, word)) return true;
        }
        board[row][col] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(i, j, 0, n, m, board, word)) return true;
            }
        }
        return false;
    }
}