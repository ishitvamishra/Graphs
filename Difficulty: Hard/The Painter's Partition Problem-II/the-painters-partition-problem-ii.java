class Solution {

    public boolean isPossible(int[] arr, int k, long maxTime) {

        int painters = 1;
        long time = 0;

        for (int i = 0; i < arr.length; i++) {

            if (time + arr[i] <= maxTime) {
                time += arr[i];
            } else {
                painters++;
                time = arr[i];
            }

            if (painters > k) {
                return false;
            }
        }

        return true;
    }

    public int minTime(int[] arr, int k) {

        if (k > arr.length) {
            return -1;
        }

        long low = 0;
        long high = 0;

        for (int board : arr) {
            low = Math.max(low, board);
            high += board;
        }

        long ans = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {

                // This time is possible.
                // Try to find a smaller answer.
                ans = mid;
                high = mid - 1;

            } else {

                // Need more time.
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}