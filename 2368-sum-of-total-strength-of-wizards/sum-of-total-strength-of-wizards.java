class Solution {

    static final int MOD = 1_000_000_007;

    public int totalStrength(int[] strength) {

        int n = strength.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Strictly Smaller
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && strength[st.peek()] >= strength[i])
                st.pop();

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && strength[st.peek()] > strength[i])
                st.pop();

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = (prefix[i] + strength[i]) % MOD;

        long[] pp = new long[n + 2];

        for (int i = 0; i <= n; i++)
            pp[i + 1] = (pp[i] + prefix[i]) % MOD;

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int l = left[i];
            int r = right[i];

            long leftCount = i - l;
            long rightCount = r - i;

            long rightSum =
                    (pp[r + 1] - pp[i + 1] + MOD) % MOD;

            long leftSum =
                    (pp[i + 1] - pp[l + 1] + MOD) % MOD;

            long contribution =
                    (rightSum * leftCount % MOD
                            - leftSum * rightCount % MOD
                            + MOD) % MOD;

            ans = (ans + contribution * strength[i]) % MOD;
        }

        return (int) ans;
    }
}