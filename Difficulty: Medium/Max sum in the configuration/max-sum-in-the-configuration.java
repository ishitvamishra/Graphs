class Solution {
    int maxSum(int[] arr) {
        // code here
        int sum = 0;
        int prevSum = 0;
        for(int i = 0; i<arr.length;i++){
            sum += arr[i];
            prevSum += i*arr[i];
        }
        int maxSum = prevSum;
        int n = arr.length;
        for(int i = 1;i<arr.length;i++){
            int currSum = prevSum -sum +n*arr[i-1];
            maxSum = Math.max(maxSum, currSum);
            prevSum = currSum;
        }
        return maxSum;
    }
}