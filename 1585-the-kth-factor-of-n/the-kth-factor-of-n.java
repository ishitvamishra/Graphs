class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();

        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                small.add(i);
                if(i != n/i) large.add(n/i);
            }
        }

        if(k <= small.size()){
            return small.get(k-1);
        }

        k = k -small.size();
        if(k <= large.size()){
            return large.get(large.size() - k);
        }

        return -1;
    }
}