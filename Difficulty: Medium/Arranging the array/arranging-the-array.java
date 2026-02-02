class Solution {

    public void Rearrange(int a[], int n) {

        int[] temp = new int[n];
        int k = 0;

        // add negatives (order preserved)
        for(int i = 0; i < n; i++){
            if(a[i] < 0)
                temp[k++] = a[i];
        }

        // add positives (order preserved)
        for(int i = 0; i < n; i++){
            if(a[i] >= 0)
                temp[k++] = a[i];
        }

        // copy back
        for(int i = 0; i < n; i++)
            a[i] = temp[i];
    }
}
