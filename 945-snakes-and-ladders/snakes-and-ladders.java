class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n*n+1];

        q.add(1);
        vis[1] = true;

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int curr = q.poll();

                if(curr == n * n) return moves;

                for(int dice = 1; dice <= 6; dice++){
                    int next = curr + dice;

                    if(next > n * n) break;

                    int[] pos = getPos(next, n);
                    int r = pos[0];
                    int c = pos[1];

                    if(board[r][c] != -1){
                        next = board[r][c];
                    }

                    if(!vis[next]){
                        q.add(next);
                        vis[next] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getPos(int num, int n){
        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;

        if((n - 1 - row) % 2 == 1){
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}