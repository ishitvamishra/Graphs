class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] freq = new int[26];
            int left = 0, right = 0;

            int unique = 0;
            int countAtLeastK = 0;

            while (right < n) {
                if (freq[s.charAt(right) - 'a'] == 0) {
                    unique++;
                }
                freq[s.charAt(right) - 'a']++;

                if (freq[s.charAt(right) - 'a'] == k) {
                    countAtLeastK++;
                }

                right++;

                while (unique > targetUnique) {
                    if (freq[s.charAt(left) - 'a'] == k) {
                        countAtLeastK--;
                    }
                    freq[s.charAt(left) - 'a']--;

                    if (freq[s.charAt(left) - 'a'] == 0) {
                        unique--;
                    }

                    left++;
                }

                if (unique == targetUnique && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }

        return maxLen;
    }
}