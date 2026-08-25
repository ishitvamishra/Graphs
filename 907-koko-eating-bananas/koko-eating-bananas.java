class Solution {
    public long canEat(int k, int[] piles){
        long total = 0;
        for(int p : piles){
            total += p / k;

            if(p % k > 0) total++;
        }

        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for(int p : piles){
            high = Math.max(high, p);
        }

        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canEat(mid, piles) <= (long)h){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return ans;
    }
}