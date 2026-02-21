class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord)) return result;

        // Map for parents
        Map<String, List<String>> parents = new HashMap<>();

        // Level tracking
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {

            dict.removeAll(currentLevel);
            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);

                        if (!dict.contains(newWord)) continue;

                        nextLevel.add(newWord);

                        parents
                            .computeIfAbsent(newWord, k -> new ArrayList<>())
                            .add(word);

                        if (newWord.equals(endWord))
                            found = true;
                    }

                    arr[i] = original;
                }
            }

            currentLevel = nextLevel;
        }

        if (!found) return result;

        List<String> path = new ArrayList<>();
        backtrack(endWord, beginWord, parents, path, result);

        return result;
    }

    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> parents,
                           List<String> path,
                           List<List<String>> result) {

        path.add(word);

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
        } else {
            for (String parent : parents.getOrDefault(word, new ArrayList<>())) {
                backtrack(parent, beginWord, parents, path, result);
            }
        }

        path.remove(path.size() - 1);
    }
}