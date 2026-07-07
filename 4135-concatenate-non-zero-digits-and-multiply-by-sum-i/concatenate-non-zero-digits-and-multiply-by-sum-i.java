class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0, num = 0, m = 1;

        while(n > 0){
            if(n % 10 != 0){
                num = num + (n % 10) * m; 
                sum += (n % 10);
                m = m * 10;
            }

            n /= 10;
        }


        return num * sum;
    }
}