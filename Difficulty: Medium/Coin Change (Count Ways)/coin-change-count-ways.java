class Solution {
    public int count(int coins[], int amount) {
        // code here.
        int[] dp = new int[amount + 1];
        dp[0] = 1; //making  amt = 0, only 1 way

        for (int coin : coins) {
            for (int amt = coin; amt <= amount; amt++) {
                dp[amt] += dp[amt - coin];
            }
        }

        return dp[amount];
    }
}