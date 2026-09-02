class Solution {
    public boolean uniformArray(int[] nums1) {
        int alag = 0;

        for(int num : nums1){
            if((num & 1) == 1) alag++;
        }

        int nau = nums1.length;
        int eve = nau - alag;

        if(nau == 1) return true;

        boolean canEven = (alag != 1);
        boolean canOdd = (alag >= 1 && eve >= 1);

        return canEven || canOdd;
    }
}