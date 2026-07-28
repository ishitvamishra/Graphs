class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int rg = arr[n -  1];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[n - 1]);
        
        
        for(int i = n - 2;  i >= 0; i--){
            if(arr[i] >= rg){
                rg = arr[i];
                res.add(rg);
            } 
        }
        
        Collections.reverse(res);
        
        return res;
    }
}
