// User function Template for Java

class Solution {
    public static void combinations(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i<candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            ds.add(candidates[i]);
            combinations(i + 1, candidates, target - candidates[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        combinations(0, a, s, ans, new ArrayList<>());
        return ans;
    }
}