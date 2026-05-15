class Solution {
    public int findMin(int[] nums) {
        int low, high;
        low = 0;
        high = nums.length - 1;
        if(nums[low]< nums[high]){
                return nums[low];
            }
        while(low < high){
            int mid = low+(high- low)/2;
            if(nums[mid] > nums[nums.length-1]){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return nums[low];

    }
}