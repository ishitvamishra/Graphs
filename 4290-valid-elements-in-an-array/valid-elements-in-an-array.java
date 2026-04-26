class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        if(n == 1) return list;

        for(int mid = 1; mid < n - 1; mid++){
            int left = 0;
            int right = n - 1;
            boolean flag1 = true, flag2 = true;

            while(left < mid){
                if(nums[left] >= nums[mid]) flag1 = false;
                left++;
            }

            while(mid < right){
                if(nums[right] >= nums[mid]) flag2 = false;
                right--;
            }

            if(flag1 || flag2) list.add(nums[mid]);
        }

        list.add(nums[n-1]);

        return list;

    }
}