import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        
        int total = 0;
        for (int num : nums) total += num;

        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, n);

        // Store subset sums grouped by count
        List<List<Integer>> leftSum = new ArrayList<>();
        List<List<Integer>> rightSum = new ArrayList<>();

        for (int i = 0; i <= half; i++) {
            leftSum.add(new ArrayList<>());
            rightSum.add(new ArrayList<>());
        }

        // Generate subset sums
        generate(left, leftSum);
        generate(right, rightSum);

        // Sort right side for binary search
        for (int i = 0; i <= half; i++) {
            Collections.sort(rightSum.get(i));
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= half; k++) {
            List<Integer> lList = leftSum.get(k);
            List<Integer> rList = rightSum.get(half - k);

            for (int lSum : lList) {
                int target = total / 2 - lSum;

                int idx = Collections.binarySearch(rList, target);
                if (idx < 0) idx = -idx - 1;

                // check idx
                if (idx < rList.size()) {
                    int sum = lSum + rList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                // check idx - 1
                if (idx > 0) {
                    int sum = lSum + rList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }

    private void generate(int[] arr, List<List<Integer>> res) {
        int n = arr.length;
        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    count++;
                }
            }

            res.get(count).add(sum);
        }
    }
}