import java.util.*;

class Solution {

    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int size) {
            n = size;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(2 * node, start, mid, idx, val);
            else
                update(2 * node + 1, mid + 1, end, idx, val);

            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 0;

            if (l <= start && end <= r)
                return tree[node];

            int mid = (start + end) / 2;

            return Math.max(
                query(2 * node, start, mid, l, r),
                query(2 * node + 1, mid + 1, end, l, r)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50000;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        // Collect all obstacles that will ever exist
        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        SegmentTree seg = new SegmentTree(MAX + 1);

        // Build initial gaps
        int prev = 0;
        for (int pos : obstacles) {
            if (pos == 0) continue;

            seg.update(1, 0, MAX, pos, pos - prev);
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {

            int[] q = queries[i];

            if (q[0] == 2) {

                int x = q[1];
                int sz = q[2];

                Integer p = obstacles.floor(x);

                int bestGap = 0;

                if (p != null) {
                    bestGap = seg.query(1, 0, MAX, 0, p);
                    bestGap = Math.max(bestGap, x - p);
                } else {
                    bestGap = x;
                }

                ans.add(bestGap >= sz);

            } else {

                int pos = q[1];

                Integer left = obstacles.lower(pos);
                Integer right = obstacles.higher(pos);

                if (right != null) {
                    seg.update(
                        1,
                        0,
                        MAX,
                        right,
                        right - left
                    );
                }

                seg.update(1, 0, MAX, pos, 0);

                obstacles.remove(pos);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}