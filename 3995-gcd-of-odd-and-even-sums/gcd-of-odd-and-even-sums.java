class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;
        int num = 1;

        for(int i = 1; i <= n; i++){
            sumOdd += (i*2 - 1);

            sumEven += (i*2);
        }

        System.out.println(sumEven);

        int ans =  0;
        for(int i = 1; i <= Math.min(sumOdd, sumEven); i++){
            if(sumOdd % i == 0 && sumEven % i == 0) ans = i;
        }

        return ans;
    }
}