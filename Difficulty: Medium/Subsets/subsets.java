class Solution {
    public void subset(int index, int[] nums, ArrayList<ArrayList<Integer>> ans , List<Integer>ds){
        if(index >= nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        subset(index+1, nums,ans,ds);
        ds.remove(ds.size()-1);
        subset(index+1,nums,ans,ds);
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subset(0,arr, ans, new ArrayList<>());
        Collections.reverse(ans);  //optional
        return ans;
    }
}