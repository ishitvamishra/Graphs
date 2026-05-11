class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for(int i = nums.length - 1; i >= 0; i--){
            int digit = nums[i];

            while(digit > 0){
                digits.add(digit % 10);
                digit /= 10;
            }
        }

        Collections.reverse(digits);
        int[] res = new int[digits.size()];
        for(int i = 0; i < digits.size(); i++){
            res[i] = digits.get(i);
        }

        return res;
    }
}