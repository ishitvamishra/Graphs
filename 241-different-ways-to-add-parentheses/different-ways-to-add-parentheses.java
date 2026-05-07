class Solution {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expr) {

        if(memo.containsKey(expr)) return memo.get(expr);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < expr.length(); i++){
            char ch = expr.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*'){

                List<Integer> left = diffWaysToCompute(expr.substring(0, i));
                List<Integer> right = diffWaysToCompute(expr.substring(i+1));

                for(int l : left){
                    for(int r : right){
                        if(ch == '+') ans.add(l+r);

                        else if(ch == '-') ans.add(l-r);

                        else ans.add(l*r);
                    }
                }
            }
        }

        if(ans.size() == 0){
            ans.add(Integer.parseInt(expr));
        }

        memo.put(expr, ans);

        return ans;
    }
}