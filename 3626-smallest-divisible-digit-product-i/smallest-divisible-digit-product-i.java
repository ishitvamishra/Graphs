class Solution {
    public int smallestNumber(int n, int t) {
        int temp = n, res = 0;
        while(true){
            res = digitProduct(temp);
            if(res % t == 0){
                break;
            }
            temp++;
        }

        return temp;
    }

    private int digitProduct(int n){
        int prod = 1;
        while(n > 0){
            prod =  prod * (n % 10);
            n = n / 10;
        }

        return prod;
    }
}