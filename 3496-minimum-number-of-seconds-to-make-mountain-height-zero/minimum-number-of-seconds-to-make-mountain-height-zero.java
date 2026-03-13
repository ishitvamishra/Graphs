class Solution {
    public long minNumberOfSeconds(int h, int[] t) {
        long l = 1, r = (long)1e18, ans = r;

        while(l <= r){
            long mid = (l + r) / 2;

            long tot = 0;

            for(int x : t){
                long val = (2 * mid) / x;
                long k = (long)((Math.sqrt(1 + 4 * val) - 1) / 2);
                tot += k;

                if(tot >= h) break;
            }

            if(tot >= h){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return ans;
    }
}