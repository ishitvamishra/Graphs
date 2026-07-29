class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxLen = 0, len = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        for(int right = 0; right < n; right++){
            if(right - left + 1 > k){
                if(set.contains(s.charAt(left))){
                    len--;
                }
                left++;
            }
            
            if(set.contains(s.charAt(right))){
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}