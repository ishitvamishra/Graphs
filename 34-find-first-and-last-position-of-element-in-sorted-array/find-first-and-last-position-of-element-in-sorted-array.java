/* Intution : the first occurence is given by lower bound directly
the last occurence will be given by upperbound - 1 because upperbound will find the first instance 
where arr[mid] > target and substracting 1 will give us the last occurence of target */

class Solution {
    public int[] searchRange(int[] nums, int target) {
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
            return new int[]{-1, -1};
        }

        return new int[]{first, last - 1};
    }
}