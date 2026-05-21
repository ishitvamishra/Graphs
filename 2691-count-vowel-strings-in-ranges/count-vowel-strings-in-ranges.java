class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
    
        HashSet<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

        int[] prefix = new int[words.length + 1];

        for(int i = 1; i <= words.length; i++){
            String word = words[i-1];
            if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))){
                prefix[i] = prefix[i-1] + 1;
            }
            else{
                prefix[i] = prefix[i-1];
            }
            
        }

        for(int i = 0; i < prefix.length; i++){
            System.out.println(prefix[i]);
        }

        int[] ans = new int[queries.length];
        int j = 0;
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];

            ans[j++] = prefix[r+1] - prefix[l];
        }

        return ans;
    }
}