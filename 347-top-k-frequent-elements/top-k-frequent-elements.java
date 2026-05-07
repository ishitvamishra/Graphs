class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));

        for (int key : freq.keySet()) {

            pq.offer(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        for(int i = k - 1; i >= 0; i--){
            res[i] = pq.poll();
        }

        return res;
    }
}