class Solution {
    int[][] dirs = {
        {-1,-1},{-1,0},{-1,1},
        {0,-1},{0,1},
        {1,-1},{1,0},{1,1}
    };
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0]; //row to be clicked
        int c = click[1]; //col to be clicked

        //if mine is found mark it X and return the board as game is over
        if(board[r][c] == 'M'){
            board[r][c] = 'X';
            return board;
        }
        //otherwise traverse neighbour
        dfs(board, r, c);
        return board;
    }

    public void dfs(char[][] board, int r, int c){
        int n = board.length;
        int m = board[0].length;
        int mines = 0;

        //count the number of mines adjacent to the traversing cell(r,c)
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < n && nc >=0 && nc < m && board[nr][nc] == 'M'){
                mines++;
            }
        }
        
        //agar ek bhi mine mil gyi toh game over, board return krdo
        if(mines > 0){
            board[r][c] = (char)(mines + '0');
            return;
        }
        //if no mine is found mark it B and call other 8 neighbours of that cell(r,c) thru dir matrix
        board[r][c] = 'B';

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < n && nc >=0 && nc < m && board[nr][nc] == 'E'){
                dfs(board, nr, nc);
            }
        } 
    }
}