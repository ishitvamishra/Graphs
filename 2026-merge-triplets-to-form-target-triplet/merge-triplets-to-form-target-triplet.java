class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;

        boolean tarA = false, tarB = false, tarC = false;
        int x =  target[0], y = target[1], z = target[2];

        for(int i = 0; i < n; i++){
            int a = triplets[i][0];
            int b = triplets[i][1];
            int c = triplets[i][2];

            if(a > x || b > y|| c > z) continue;

            if(a == x) tarA = true;
            if(b == y) tarB = true;
            if(c == z) tarC = true;

            if(tarA && tarB && tarC) return true;
        }

        return false;
    }
}