class Solution {
    private long canEat(int[] nums, int capacity){
        long total = 0;
        for(int n : nums){
            //number pf bananas / your capacity
            total += n / capacity;
            if(n % capacity > 0) total++;
        }

        return total;
    }
    public int minEatingSpeed(int[] nums, int k) {
        int low = 1, high = 0;
        for(int wt : nums){
            high = Math.max(high, wt);
        }

        int ans = high;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canEat(nums, mid) <= (long)k){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}