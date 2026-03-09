class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int smaller = 0, same = 0;

        for(int num : nums){
            if(num < pivot) smaller++;
            else if(num == pivot) same++;
        }

        int left = 0, mid = smaller, right = smaller + same;

        for(int num : nums){
            if(num < pivot) res[left++] = num;
            
            else if(num > pivot) res[right++] = num;

            else res[mid++] = num;
        }

        return res;

    }
}