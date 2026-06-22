class Solution {
    private int daysNeeded(int[] weights, int capacity){
        int days = 1;
        int curr = 0;

        for(int w : weights){
            if (curr + w <= capacity) {
                curr += w;
            } else {
                days++;
                curr = w;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int wt : weights){
            low = Math.max(low, wt);
            high += wt;
        }

        int ans = high;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(daysNeeded(weights, mid) <= days){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}