class Solution {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expr) {

        //Store for overlapping expressiom
        if(memo.containsKey(expr)) return memo.get(expr);

        //for each fn call, a new list is made 
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < expr.length(); i++){
            char ch = expr.charAt(i);

            //when operator is found split to left part and right part
            if(ch == '+' || ch == '-' || ch == '*'){

                List<Integer> left = diffWaysToCompute(expr.substring(0, i));
                List<Integer> right = diffWaysToCompute(expr.substring(i+1));

                //each time left and right will have a single value and ch will hold the operator 
                for(int l : left){
                    for(int r : right){
                        if(ch == '+') ans.add(l+r);

                        else if(ch == '-') ans.add(l-r);

                        else ans.add(l*r);
                    }
                }
            }
        }

        //when the expr will not hold any operator then this base case will  hit
        if(ans.size() == 0){
            ans.add(Integer.parseInt(expr));
        }

        memo.put(expr, ans);

        return ans;
    }
}