class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxLen = 0, len = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        for(int right = 0; right < n; right++){
            if(set.contains(s.charAt(right))){
                len++;
            }

            if(right - left + 1 == k){
                maxLen = Math.max(maxLen, len);
                if(set.contains(s.charAt(left))){
                    len--;
                }
                left++;
            }

        }

        return maxLen;
    }
}