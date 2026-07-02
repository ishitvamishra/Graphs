class Solution {
    public int characterReplacement(String s, int k) {
        //Invariant is length - maxfreq element in that length < k
        int[] freq = new int[26];
        int left = 0, right = 0, maxLen = 0, maxCount = 0;

        while(right < s.length()){
            freq[s.charAt(right) - 'A']++;

            maxCount = Math.max(freq[s.charAt(right)-'A'], maxCount);

            while((right - left + 1) - maxCount > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
        
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}