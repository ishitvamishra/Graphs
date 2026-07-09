class Solution {
    public int minSwaps(int arr[]) {
        int n = arr.length;
        
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(sorted[i], i);
        }
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for(int i = 0; i < n; i++){
            if(visited[i] || map.get(arr[i]) == i) continue;
            
            int j = i;
            int cycleSize = 0;
            
            while(!visited[j]){
                visited[j] = true;
                j = map.get(arr[j]);
                cycleSize++;
            }
            
            swaps += cycleSize - 1;
        }
        
        return swaps;
    }
}