class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int min = Integer.MAX_VALUE;
        for(List<Integer> list : map.values()){
            if(list.size() >= 3){
                for(int i = 0; i < list.size() - 2; i++){
                    int p = list.get(i);
                    int q = list.get(i + 1);
                    int r = list.get(i + 2);

                    min = Math.min(min, 2 * (Math.max(p, Math.max(q, r)) - Math.min(p, Math.min(q, r))));
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}