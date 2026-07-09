class Solution {
    public int findKRotation(int nums[]) {
        // Code here
        int low = 0, high = nums.length - 1;

        if(nums[low] <= nums[high]) return 0;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            } else{
                high = mid;
            }
        }
        
        return low;
    }
}