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
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j < m; j++){
                ans.get(i).add(0);
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        int vis[][] = new int [n][m];
        
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
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
            ans.get(row).set(col, steps);
            
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