class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        HashSet<String> set = new HashSet<>();
        for(String s : nums){
            set.add(s);
        }

        return generate("", n, set);
    }

    public String generate(String curr, int n, HashSet<String> set){
        if(curr.length() == n){
            if(!set.contains(curr)){
                return curr;
            }
            return null;
        }

        String left = generate(curr + "0", n, set);

        if(left != null) return left;

        String right = generate(curr + "1", n, set);
        
        return right;
    }
}