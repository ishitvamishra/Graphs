class Solution {
    private long canEat(int[] nums, int capacity){
        long total = 0;
        for(int n : nums){
            total += n / capacity;
        }

        return total;
    }
    public int maximumCandies(int[] nums, long k) {
        int low = 1, high = 0;
        for(int wt : nums){
            high = Math.max(high, wt);
        }

        int ans = 0;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canEat(nums, mid) >= k){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
                
            }
        }

        return ans;
    }
}