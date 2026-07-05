class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            //check if target is equal to nums[mid]
            if(nums[mid] == target) return mid;

            //check if left half is sorted or not -> either left half will be sorted or right 
            if(nums[low] <= nums[mid]){
                //look for target in left half if yes eliminate right half otherwise eliminate left half
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                } else{
                    low = mid + 1;
                }
            } else{
                //check if target is present in the right half or not, if yes eliminate left else right
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}