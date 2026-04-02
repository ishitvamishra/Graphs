// User function Template for Java

class Solution {
    static int maximizeMoney(int n, int K) {
        // code here
        if(n == 1 || n == 2) return K;
        int[] sum = new int[n];
        
        sum[0] = K;
        sum[1] = K;
        for(int i = 2;i<n;i++){
            sum[i] = Math.max(sum[i-1], sum[i-2]+ K);
        }
        
        return sum[n-1];
    }
};