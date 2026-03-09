class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];

        List<Integer> perfect = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            perfect.add(i*i);
        }

        q.add(n);
        vis[n] = true;

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int x = q.poll();

                for(int p : perfect){
                    if(p <= x){
                        int num = x -  p;

                        if(num == 0) return steps + 1;

                        if(!vis[num]){
                            q.add(num);
                            vis[num] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}