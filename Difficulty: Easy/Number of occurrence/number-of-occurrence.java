class Solution {
    int countFreq(int[] nums, int target) {
        // code here
        int low = 0, high = nums.length - 1;
        int first = nums.length;

        while(low <= high){
            int mid =  low + (high - low) / 2;

            if(nums[mid] >= target){
                first = mid;
                high = mid - 1;
            } else{
                low= mid + 1;
            }
        }

        int last = nums.length;
        low = 0; high = nums.length - 1;
        while(low <= high){
            int mid =  low + (high - low) / 2;

            if(nums[mid] > target){
                last = mid;
                high = mid - 1;
            } else{
                low= mid + 1;
            }
        }

        if(first == nums.length || nums[first] != target){
            return 0;
        }

        return last - first;
    }
}
