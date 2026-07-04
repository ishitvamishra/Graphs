class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int low = 0, high = arr.length -  1;
        int minIndex = arr.length;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(arr[mid] >= target){
                high = mid - 1;
                minIndex = mid;
            } else{
                low = mid + 1;
            }
        }
        
        return minIndex;
    }
}
