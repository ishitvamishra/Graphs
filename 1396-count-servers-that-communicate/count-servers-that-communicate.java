class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] rowCnt=new int[n]; 
        int[] colCnt=new int[m];

        // Count servers in each row and column
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){                   
                    rowCnt[i]++;
                    colCnt[j]++;                    
                }
            }
        }

        int cnt=0;
        // Count communicating servers
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){                   
                    if(rowCnt[i]>1 || colCnt[j]>1){
                        cnt++;
                    }                 
                }
            }
        }

        return cnt;
    }
}