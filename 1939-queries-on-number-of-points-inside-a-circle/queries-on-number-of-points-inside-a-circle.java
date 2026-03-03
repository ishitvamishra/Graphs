class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int j = 0;
        for(int[] query : queries){
            int count = 0;
            int x1 = query[0];
            int y1 = query[1];
            int r1 = query[2];

            for(int i = 0; i < points.length; i++){
                int[] point = points[i];

                int x2 = point[0];
                int y2 = point[1];

                int x = x2 - x1;
                int y = y2 - y1;

                if(x * x + y * y <= r1 * r1){
                    count++;
                }
            }
            ans[j++] = count; 
        }
        return ans;
    }
}