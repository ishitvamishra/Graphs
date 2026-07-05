class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(x, new ArrayList<>());

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == x){
                map.get(x).add(i);
            }
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for(int q : queries){
            if(q > map.get(x).size()){
                ans[i] = -1;
            } else{
                ans[i] = map.get(x).get(q - 1);
            }
            i++;
        }

        return ans;
    }
}