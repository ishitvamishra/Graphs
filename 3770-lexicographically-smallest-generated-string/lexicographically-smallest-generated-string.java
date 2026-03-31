class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] word = new char[n + m - 1];
        Arrays.fill(word, '?');

        // Step 1: enforce 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 2: fill remaining with 'a'
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 3: fix 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;

                    for (int j = m - 1; j >= 0 && !changed; j--) {
                        int idx = i + j;

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != word[idx]) {
                                char old = word[idx];
                                word[idx] = c;

                                // check all 'T' constraints again
                                if (valid(word, str1, str2)) {
                                    changed = true;
                                    break;
                                }

                                word[idx] = old;
                            }
                        }
                    }

                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }

    private boolean valid(char[] word, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}