class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int num = nums[0];

        int moves = 0;
        for(int i = 1; i < nums.length; i++){
            moves += (nums[i] - num);
        }

        return moves;
    }
}