class Solution {
    public void subsets(int index, int[] nums, ArrayList<ArrayList<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for(int i = index; i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;

            ds.add(nums[i]);
            subsets(i + 1, nums, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        subsets(0, arr, ans, new ArrayList<>());
        return ans;
    }
}
