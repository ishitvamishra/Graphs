class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int mx = 0;

        for(int i = 0; i < candies.length; i++){
            mx = Math.max(mx, candies[i]);
        }

        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= mx){
                res.add(true);
            }else{
                res.add(false);
            }
        }

        return res;
    }
}