class Solution {
    public void solve(int col, int n, int[] lr, int[] ud, int[] ld, int[] pos, ArrayList<ArrayList<Integer>> res) {
        
        if (col == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(pos[i]);
            }
            res.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (lr[row] == 0 && ld[row + col] == 0 && ud[n - 1 + col - row] == 0) {

                lr[row] = 1;
                ld[row + col] = 1;
                ud[n - 1 + col - row] = 1;

                pos[row] = col + 1;

                solve(col + 1, n, lr, ud, ld, pos, res);

                lr[row] = 0;
                ld[row + col] = 0;
                ud[n - 1 + col - row] = 0;
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int[] lr = new int[n];
        int[] ld = new int[2 * n - 1];
        int[] ud = new int[2 * n - 1];
        int[] pos = new int[n];

        solve(0, n, lr, ud, ld, pos, res);
        return res;
    }
}