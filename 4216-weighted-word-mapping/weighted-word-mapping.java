class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();
        for(String word: words){
            int total = 0;
            for(char c: word.toCharArray()){
                total += weights[c-'a'];
            }
            int modVal = total % 26;

            char mappedChar = (char)('a' + (25 - modVal));
            res.append(mappedChar);
        }
        return res.toString();
    }
}