class State{
    int row;
    int col;
    int keys;

    State(int row, int col, int keys){
        this.row = row;
        this.col = col;
        this.keys = keys;
    }
}

class Solution {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        int startRow = 0, startCol = 0;
        int totalKeys = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = grid[i].charAt(j);

                if(ch == '@'){
                    startRow = i;
                    startCol = j;
                }

                if(ch >= 'a' && ch <= 'f'){
                    totalKeys = Math.max(totalKeys, ch - 'a' + 1);
                }
            }
        }
        
        int targetMask = (1 << totalKeys) - 1;
        Queue<State> q = new LinkedList<>();
        boolean [][][] vis = new boolean[n][m][64];

        q.add(new State(startRow, startCol, 0));
        vis[startRow][startCol][0] = true;

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int row = q.peek().row;
                int col = q.peek().col;
                int mask = q.peek().keys;
                q.remove();

                if(mask == targetMask) return steps;

                for(int d = 0; d < 4; d++){
                    int nr = row + dx[d];
                    int nc = col + dy[d];
                    int newMask = mask;

                    if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                    char cell = grid[nr].charAt(nc);

                    if(cell == '#') continue;

                    // key
                    if(cell >= 'a' && cell <= 'f') {
                        newMask = mask | (1 << (cell - 'a'));
                    }

                    // lock
                    if(cell >= 'A' && cell <= 'F') {
                        if((mask & (1 << (cell - 'A'))) == 0) continue;
                    }

                    if(!vis[nr][nc][newMask]) {
                        vis[nr][nc][newMask] = true;
                        q.add(new State(nr, nc, newMask));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}