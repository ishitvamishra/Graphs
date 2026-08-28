class Solution {
    private boolean isPossible(int[] arr, int dist, int k){
        int cows = 1;
        int last = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - last >= dist){
                cows++;
                last = arr[i];
            }
            
            if(cows >= k){
                return true;
            }
        }
        
        return false;
    }
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        
        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isPossible(arr, mid, k)){
                ans =  mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        
        return ans;
    }
}