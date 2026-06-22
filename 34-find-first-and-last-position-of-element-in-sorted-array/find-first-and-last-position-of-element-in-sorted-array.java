class Solution {

    private int firstOccurence(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                //for first occurence we need to keep looking at left side for first occ, hence high = mid - 1
                ans = mid;
                high = mid - 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        return ans;
    }

    private int lastOccurence(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                //for last occurence we need to keep looking at right side for last occ, hence low = mid + 1
                ans = mid;
                low = mid + 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            firstOccurence(nums, target),
            lastOccurence(nums, target)
        }; 
    }
}