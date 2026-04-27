class Solution {
    int distinctSubseq(String s) {
        // code here
         int mod = 1000000007;

        long total = 1; // empty subsequence
        long[] last = new long[26]; // contribution of last occurrence

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            long newTotal = (2 * total % mod - last[idx] + mod) % mod;

            // update last contribution
            last[idx] = total;

            total = newTotal;
        }

        // remove empty subsequence
        return (int)((total + mod) % mod);
    }
}