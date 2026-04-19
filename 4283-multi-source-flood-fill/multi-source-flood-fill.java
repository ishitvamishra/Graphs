class State{
    int dist;
    int color;
    int row;
    int col;
    

    State(int dist, int color, int row, int col){
        this.row = row;
        this.col = col;
        this.dist = dist;
        this.color = color;
    }
}

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // PQ: distance ↑ , color ↓
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            return b.color - a.color;
        });

        // initialize sources
        for (int[] src : sources) {
            int r = src[0], c = src[1], col = src[2];
            pq.offer(new State(0, col, r, c));
        }

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            int r = curr.row;
            int c = curr.col;

            if (visited[r][c]) continue;

            visited[r][c] = true;
            grid[r][c] = curr.color;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    pq.offer(new State(curr.dist + 1, curr.color, nr, nc));
                }
            }
        }

        return grid;
    }
}