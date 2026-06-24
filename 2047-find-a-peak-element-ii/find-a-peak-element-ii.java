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
            //mid column ko denote kr rha
            int mid = low + (high - low) / 2;
            //mid wali column se maxElement ka row nikal lo
            int maxRow = findMax(nums, mid);
            //maxElement ke upar neeche wale check krne ki need h nhi, just left aur right save krlo check krne ke liye
            int left = (mid == 0) ? -1 : nums[maxRow][mid - 1];
            int right = (mid == nums[0].length - 1) ? -1 : nums[maxRow][mid + 1];

            //if curr > left and right return curr's index
            if(nums[maxRow][mid] > left && nums[maxRow][mid] > right){
                return new int[] {maxRow, mid};
            }
            //right me agar peak h toh low right me shift krdo
            if(right > nums[maxRow][mid]){
                low = mid + 1;
            } else{
                high = mid - 1; // high left me shift krdo
            }
        }
        return new int[]{-1, -1};
    }
}