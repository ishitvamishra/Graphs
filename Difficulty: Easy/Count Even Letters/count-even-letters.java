class Solution {
    public int count(String s) {
        // code here
        int count = 0;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < freq.length; i++){
            if(freq[i] % 2 == 0 && freq[i] != 0){
                count++;
            }
        }
        return count;
    }
}