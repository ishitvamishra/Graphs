class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }

    public int atmost(int[] nums, int k){
        if(k < 0) return 0;

        int n = nums.length;
        int left = 0, count = 0;

        for(int right = 0; right < n; right++){
            if(nums[right] % 2 != 0) k--;

            while(k < 0){
                if(nums[left] % 2 != 0){
                    k++;
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}