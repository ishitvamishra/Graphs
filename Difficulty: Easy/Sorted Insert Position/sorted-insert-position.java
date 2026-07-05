class Solution {
    public int searchInsertK(int nums[], int target) {
        // code here
        int low =  0, high = nums.length - 1;
        int ans = nums.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] >=  target){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return ans;
    }
};