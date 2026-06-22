class Solution {
    private int kNeeded(int[] nums, int capacity){
        int k = 1;
        int curr = 0;

        for(int w : nums){
            if (curr + w <= capacity) {
                curr += w;
            } else {
                k++;
                curr = w;
            }
        }

        return k;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int wt : nums){
            low = Math.max(low, wt);
            high += wt;
        }

        int ans = high;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(kNeeded(nums, mid) <= k){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}