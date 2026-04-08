class Solution {
    public int findPermutationDifference(String s, String t) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            int idx = t.indexOf(ch);

            int diff = Math.abs(i - idx);
            sum += diff;
        }

        return sum;
    }
}