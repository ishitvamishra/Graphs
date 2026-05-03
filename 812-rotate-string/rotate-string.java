class Solution {
    public boolean rotateString(String s, String goal) {
        String str = s + s;

        for (int i = 0; i < s.length(); i++) {
            if (str.substring(i, i + s.length()).equals(goal)) {
                return true;
            }
        }

        return false;
    }
}