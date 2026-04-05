class Solution {
    public int maximumPoints(int points[][]) {
        int n = points.length;
        // code here
        int[][] dp = new int[n][4];
        //dp[day][last] is max points on 'day' gives last day was 'last' and ignoring last

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;

                for(int task = 0; task < 3; task++){
                    if(task != last){
                        //aaj ke task ka point + pichle kl same task ko last task consider krke max points through dp
                        //dp[1][0] = max of dp[1][1] + dp[0][1] or dp[1][2] + dp[0][2]
                        ///day 1 pe considering last task 0 hai => day 1 pe task 1 ke points + day 0 pe considering last task 1 hai
                        //day 0 pe task 1 ko last task consider kr rhey tabhi day 1 pe task 1 select kr parhe 
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[n-1][3];
    }
}