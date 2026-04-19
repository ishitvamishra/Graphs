class State {
    int row;
    int col;
    int color;

    State(int row, int col, int color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
}

class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        int[][] time = new int[n][m];
        Queue<State> q = new LinkedList<>();

        for (int[] source : sources) {
            int row = source[0];
            int col = source[1];
            int color = source[2];

            grid[row][col] = color;
            time[row][col] = time[row][col] + 1;
            q.add(new State(row, col, color));
        }

        while (!q.isEmpty()) {
            State curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int col = curr.color;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (time[nr][nc] == 0) {
                        grid[nr][nc] = col;
                        time[nr][nc] = time[r][c] + 1;
                        q.add(new State(nr, nc, col));
                    }
                    else if (time[nr][nc] == time[r][c] + 1) {
                        if (grid[nr][nc] < col) {
                            grid[nr][nc] = col;
                            q.add(new State(nr, nc, col));
                        }
                    }
                }
            }
        }

        return grid;
    }
}