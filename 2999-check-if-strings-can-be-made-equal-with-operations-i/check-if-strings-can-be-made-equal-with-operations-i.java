class Solution {
    public boolean canBeEqual(String s1, String s2) {

        // Case 1: no swap
        if (s1.equals(s2)) return true;

        // Case 2 & 3: single swaps
        for (int i = 0; i < 2; i++) {
            char[] arr = s1.toCharArray();

            int j = i + 2;

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            String str = new String(arr);
            if (str.equals(s2)) return true;
        }

        // Case 4: both swaps
        char[] arr = s1.toCharArray();

        // swap (0,2)
        char temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;

        // swap (1,3)
        temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;

        if (new String(arr).equals(s2)) return true;

        return false;
    }
}