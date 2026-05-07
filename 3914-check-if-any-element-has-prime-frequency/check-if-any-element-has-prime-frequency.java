class Solution {
    private boolean checkPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean checkPrimeFrequency(int[] nums) {
        int[] storage = new int[101];
        for (int num : nums) {
            storage[num]++;
        }
        for (int freq : storage) {
            if (checkPrime(freq)) return true;
        }
        return false;
    }
}