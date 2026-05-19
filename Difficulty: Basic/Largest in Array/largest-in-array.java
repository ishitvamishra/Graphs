class Solution {
    public static int largest(int[] arr) {
        // code here
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        
        return max;
    }
}
