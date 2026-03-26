class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProd = new int[n];
        int[] sufProd = new int[n];
        preProd[0] = 1;
        sufProd[n - 1] = 1;

        for(int i = 1; i < n; i++){
            preProd[i] = nums[i - 1] * preProd[i-1];
            sufProd[n - i - 1] = nums[n - i] * sufProd[n - i];
        }

        for(int i = 0; i < n; i++){
            preProd[i] = preProd[i] * sufProd[i];
        }

        return preProd;
    }
}