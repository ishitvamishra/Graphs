class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256];

        int maxLen = 0, left = 0;

        for(int right = 0; right < n; right++){
            hash[s.charAt(right)]++;

            while(hash[s.charAt(right)] > 1){
                hash[s.charAt(left)]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}