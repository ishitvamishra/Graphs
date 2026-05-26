class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;
        int num = 1;

        for(int i = 1; i <= n; i++){
            sumOdd += (i*2 - 1);

            sumEven += (i*2);
        }

        return gcd(sumOdd, sumEven);
    }

    public int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a, a);
    }
}