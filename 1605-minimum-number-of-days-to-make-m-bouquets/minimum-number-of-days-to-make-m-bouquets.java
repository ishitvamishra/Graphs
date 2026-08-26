class Solution {
    private boolean possible(int days, int[] bloomDay, int m, int k){
        int cnt =  0;
        int total = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <=  days){
                cnt++;
            } else{
                total += (cnt / k);
                cnt = 0;
            }
        }
        total += (cnt / k);

        return total >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = Integer.MAX_VALUE, high = 0;

        if((long)m * k > n) return -1;

        for(int i = 0; i < n; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(possible(mid, bloomDay, m, k)){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return ans;
    }
}