class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            // only one occurrence
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            // binary search to find position of idx in list
            int pos = Collections.binarySearch(list, idx);

            int size = list.size();

            // left neighbor (circular)
            int leftIdx = list.get((pos - 1 + size) % size);
            int distLeft = Math.abs(idx - leftIdx);
            distLeft = Math.min(distLeft, n - distLeft);

            // right neighbor (circular)
            int rightIdx = list.get((pos + 1) % size);
            int distRight = Math.abs(idx - rightIdx);
            distRight = Math.min(distRight, n - distRight);

            ans.add(Math.min(distLeft, distRight));
        }

        return ans;
    }
}