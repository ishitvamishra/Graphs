class Solution {
    public int longestStringChain(String[] words) {
    Arrays.sort(words, (a, b) -> a.length() - b.length());

    HashMap<String, Integer> dp = new HashMap<>();
    int maxLen = 1;

    for (String word : words) {
        int best = 1;

        for (int i = 0; i < word.length(); i++) {
            String prev = word.substring(0, i) + word.substring(i + 1);
            best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
        }

        dp.put(word, best);
        maxLen = Math.max(maxLen, best);
    }

    return maxLen;
}
}