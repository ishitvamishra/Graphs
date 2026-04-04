class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        HashMap<Integer, String> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String res[] = new String[n];

        for(int i = 0; i < n; i++){
            res[n - i - 1] = map.get(heights[i]);
        }

        return res;
    }
}