class Solution {
    public boolean isStrictlyPalindromic(int n) {
        String s = "";
        for(int i = 2; i <= n-2; i++){
            int temp = n;
            while(temp >0){
                s+= temp % i;
                temp /= i;
            }
            if(!isPalindrome(s)){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) !=  s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}