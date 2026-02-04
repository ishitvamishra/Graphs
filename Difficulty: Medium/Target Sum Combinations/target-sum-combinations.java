class Solution {
    public void combinations(int index, int[] candidates, int target, ArrayList<ArrayList<Integer>> ans, List<Integer>ds){
        if(index == candidates.length){
            if(target== 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[index] <= target){
            ds.add(candidates[index]);
            combinations(index,candidates,target-candidates[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        combinations(index+1, candidates,target,ans,ds);
    }
    
    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }
}