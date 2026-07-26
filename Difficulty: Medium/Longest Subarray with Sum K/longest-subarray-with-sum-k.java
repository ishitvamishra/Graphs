class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Long, Integer> map = new HashMap<>();
        
        long sum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            
            if(sum == k){
                maxLen = i + 1;
            }
            
            if(map.containsKey(sum - k)){
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            
            map.putIfAbsent(sum, i);
        }
        
        return maxLen;
    }
}
