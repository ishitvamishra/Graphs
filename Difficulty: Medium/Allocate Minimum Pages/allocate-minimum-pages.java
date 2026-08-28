class Solution {

    public boolean isPossible(int[] arr, int k, long maxPages) {

        int students = 1;
        long pages = 0;

        for (int i = 0; i < arr.length; i++) {

            if (pages + arr[i] <= maxPages) {
                pages += arr[i];
            } else {
                students++;
                pages = arr[i];
            }

            if (students > k) {
                return false;
            }
        }

        return true;
    }

    public int findPages(int[] arr, int k) {

        if (k > arr.length) {
            return -1;
        }

        long low = 0;
        long high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        long ans = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {

                ans = mid;

                // Try to minimize maximum pages
                high = mid - 1;

            } else {

                // Need more pages per student
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}