class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[] = new int[128];
        Arrays.fill(hash,-1);
        int n = s.length();

        int l = 0, r= 0, maxLen = 0;

        while(r < n){
            if(hash[s.charAt(r)] >= l){
                l = hash[s.charAt(r)]+1;
            }

            int len = r-l+1;
            maxLen = Math.max(len, maxLen);

            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}
