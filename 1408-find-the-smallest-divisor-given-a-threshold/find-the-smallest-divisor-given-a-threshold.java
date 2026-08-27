class Solution {
    public boolean isPossible(int[] nums, int threshold, int div){
        int total = 0;
        for(int i  = 0; i < nums.length; i++){
            total += (nums[i] + div - 1) / div;
        }

        return total <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int low = 1, high = 0;

        for(int i = 0; i < n; i++){
            high = Math.max(high, nums[i]);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(nums, threshold, mid)){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return ans;
    }
}