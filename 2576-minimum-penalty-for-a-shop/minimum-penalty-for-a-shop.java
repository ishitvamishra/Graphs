class Solution {
    public int bestClosingTime(String customer) {
        int[] prefix = new int[customer.length() + 1];
        int[] suffix = new int[customer.length() + 1];

        for(int i = 1; i <= customer.length(); i++){

            if(customer.charAt(i-1) == 'N') prefix[i] = prefix[i-1] + 1;

            else prefix[i] = prefix[i - 1];
        }

        for(int i = customer.length() - 1; i >= 0; i--){

            if(customer.charAt(i) == 'Y') suffix[i] = suffix[i+1] + 1;

            else suffix[i] = suffix[i + 1];
        }

        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= customer.length(); i++){
            if(prefix[i] + suffix[i] < min){
                min = prefix[i] + suffix[i];
                index = i;
            }
        }

        return index;
    }
}