// User function Template for Java//User function Template for Java
class Solution {
    public void subSum(int index, int sum, int[] arr, List<Integer>ds){
        if(index>=arr.length){
            ds.add(sum);
            return;
        }
        
        subSum(index+1,sum+arr[index],arr,ds);
        subSum(index+1,sum,arr,ds);
    }
    
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        subSum(0,0,arr,ans);
        return ans;
    }
}