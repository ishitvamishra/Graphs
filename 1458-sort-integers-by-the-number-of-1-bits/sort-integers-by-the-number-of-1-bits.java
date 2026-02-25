class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] temp = new Integer[arr.length];
        
        // int[] → Integer[] (because custom sort needs object array)
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        
        Arrays.sort(temp, (a, b) -> {
            
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);
            
            if(bitsA == bitsB)
                return a - b;     // normal ascending
            
            return bitsA - bitsB; // sort by bit count
        });
        
        // convert back to int[]
        for(int i = 0; i < arr.length; i++){
            arr[i] = temp[i];
        }
        
        return arr;
    }
}