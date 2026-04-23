class Solution {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        
        //dp[i] = current coins ke saath amount i banane ke total ways
        long[] dp = new long[n + 1];
        dp[0] = 1; // kuch bhi mat lo toh 0 ban jayega

        List<Integer> coins = new ArrayList<>();
        for(int i = 1; i <= n; i++){

            if(dp[i] > numWays[i - 1]){
                return new ArrayList<>();
            }

            if(dp[i] < numWays[i - 1]){
                coins.add(i);

                for(int j = i; j <= n; j++){
                    dp[j] += dp[j - i];
                }

                if (dp[i] != numWays[i - 1]) {
                    return new ArrayList<>();
                }
            }
        }

        return coins;
    }
}