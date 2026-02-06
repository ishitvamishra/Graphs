class Solution {
    public boolean solveSudoku(int[][] mat) {
        // code here
        for(int row = 0; row<9; row++){
            for(int col = 0; col<9;col++){
                if(mat[row][col] ==  0){
                    for(int i = 1;i<=9;i++){
                        if(solve(row,col,mat,i)){
                            mat[row][col] =  i;
                            
                            if(solveSudoku(mat)){
                                return true;
                            }
                            mat[row][col] = 0;
                        }
                    }
                    return false;  //for loop me kisi bhi number ke liye safe nhi hai isilye for loop ke bahar return false kiye h 
                }
            }
        }
        return true;
    }
    
    public boolean solve(int row, int col, int[][] mat, int n){
        for(int i = 0;i<9;i++){
            if(mat[i][col] == n) return false;
            if(mat[row][i] == n) return false;
            
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;
            
            if(mat[r][c] == n) return false; 
        }
        return true;
    }
}