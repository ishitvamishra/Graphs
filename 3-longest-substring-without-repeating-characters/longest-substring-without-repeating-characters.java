class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[128];

        int l = 0, maxLen = 0;

        for(int r = 0; r < n; r++){
            char ch = s.charAt(r);
            hash[ch]++;

            while(hash[ch] > 1){
                hash[s.charAt(l)]--;
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}