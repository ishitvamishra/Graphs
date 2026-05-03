class Solution {
    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == '*') {
                i--; 
            } else {
                arr[i++] = arr[j]; 
            }
        }

        return new String(arr, 0, i);
    }
}