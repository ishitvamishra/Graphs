class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[1001];

        q.add(start);
        vis[start] = true;

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int x = q.poll();

                for(int num : nums){
                    int add = x + num;
                    int sub = x - num;
                    int xor = x ^ num;

                    if(add == goal || sub == goal || xor == goal){
                        return steps + 1;
                    }

                    if(add >= 0 && add <= 1000 && !vis[add]){
                        q.add(add);
                        vis[add] = true;
                    }

                    if(sub >= 0 && sub <= 1000 && !vis[sub]){
                        q.add(sub);
                        vis[sub] = true;
                    }

                    if(xor >= 0 && xor <= 1000 && !vis[xor]){
                        q.add(xor);
                        vis[xor] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}