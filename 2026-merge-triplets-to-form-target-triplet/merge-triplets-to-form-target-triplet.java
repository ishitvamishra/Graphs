class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;

        boolean tarA = false, tarB = false, tarC = false;



        for(int i = 0; i < n; i++){
            int a = triplets[i][0];
            int b = triplets[i][1];
            int c = triplets[i][2];

            if(a > target[0] || b > target[1] || c > target[2]) continue;

            if(a == target[0]) tarA = true;
            if(b == target[1]) tarB = true;
            if(c == target[2]) tarC = true;
        }

        if(tarA && tarB && tarC) return true;

        return false;
    }
}