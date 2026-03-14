class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] edge : edges){
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        for(int val : map.keySet()){
            if(map.get(val) == map.size() - 1){
                return val;
            }
        }
        return -1;
    }
}