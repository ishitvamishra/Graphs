class Solution {
    public void solve(int start, int n, int k, List<Integer> ans, List<List<Integer>> res){
        if(k == 0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(start > n){
            return;
        }

        //add current element
        ans.add(start);
        //pick
        solve(start+1, n, k-1, ans, res);
        //backtrack
        ans.remove(ans.size()-1);
        //not pick
        solve(start+1, n, k, ans, res);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(1, n, k, ans, res);
        return res;
    }
}