class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder(s.substring(0,k));
        String rev = sb.reverse().toString();

        return rev + s.substring(k);
    }
}