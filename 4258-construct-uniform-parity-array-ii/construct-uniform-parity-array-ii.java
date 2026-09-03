class Solution {
    public boolean uniformArray(int[] nums1) {
        int nau = nums1.length;

        int[] ravo = nums1;

        if(nau == 1) return true;

        Arrays.sort(ravo);

        Integer so = null;
        Integer se = null;

        int alag = 0;
        int min = Integer.MAX_VALUE;

        for(int x : ravo){
            if((x & 1) == 1){
                if(so == null) so = x;
            }else{
                if(se == null) se = x;
            }
        }

        int even = nau - alag;

        boolean canEven = true;
        for(int x : ravo){
            if((x & 1) == 1){
                if(so == null || so >= x){
                    canEven = false;
                    break;
                } 
            }
        }

        boolean canOdd = true;
            for(int x : ravo){
                if((x & 1) == 0){
                    if(so == null || so >= x){
                        canOdd = false;
                        break;
                    }
                }
            }
        

        return canEven || canOdd;
    }
}