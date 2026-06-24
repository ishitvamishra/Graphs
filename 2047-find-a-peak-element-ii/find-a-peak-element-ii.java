class Solution {
    private int findMax(int[][] nums, int col){
        int maxRow = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[maxRow][col] < nums[i][col]){
                maxRow = i;
            }
        }

        return maxRow;
    }

    public int[] findPeakGrid(int[][] nums) {
        int low = 0;
        int high = nums[0].length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int maxRow = findMax(nums, mid);
            int left = (mid == 0) ? -1 : nums[maxRow][mid - 1];
            int right = (mid == nums[0].length - 1) ? -1 : nums[maxRow][mid + 1];

            if(nums[maxRow][mid] > left && nums[maxRow][mid] > right){
                return new int[] {maxRow, mid};
            }

            if(right > nums[maxRow][mid]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}