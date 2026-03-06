class State{
    int dist;
    int row;
    int col;

    State(int dist, int row, int col){
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int minCostPath(int[][] heights) {
        // code here
        PriorityQueue<State> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);

        int n = heights.length;
        int m = heights[0].length;
        int[][] distance = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                distance[i][j] = (int)1e9;
            }
        }

        pq.add(new State(0,0,0));
        distance[0][0] = 0;

        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();

            if(row == n-1 && col == m-1) return dist;

            for(int i = 0; i < 4; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int newEffort = Math.max(Math.abs(heights[nr][nc] - heights[row][col]), dist);
                    if(newEffort < distance[nr][nc]){
                        distance[nr][nc] = newEffort;
                        pq.add(new State(newEffort, nr, nc));
                    }
                }
            }
        }
        return -1;
    }
}
