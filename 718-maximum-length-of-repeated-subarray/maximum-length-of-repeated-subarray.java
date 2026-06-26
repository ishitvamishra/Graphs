class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int k =  0;
                while(i + k < n && j + k < m && nums1[i+k] == nums2[j+k]){
                    k++;
                }

                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
}