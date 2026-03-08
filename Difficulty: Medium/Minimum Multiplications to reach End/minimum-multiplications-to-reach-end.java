class Pair{
    int node;
    int steps;
    
    Pair(int node, int steps){
        this.node = node;
        this.steps = steps;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        int[] dist = new int[100000];
        
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;
        int mod = 100000;
        int n = arr.length;
        while(!q.isEmpty()){
            int node = q.peek().node;
            int steps = q.peek().steps;
            q.remove();
            
            for(int i = 0; i < n; i++){
                int num = (arr[i] * node) % mod;
                if(steps + 1 < dist[num]){
                    dist[num] = steps+1;
                    if(num == end) return steps+1;
                    q.add(new Pair(num, steps+1));
                }
            }
        }
        return -1;
    }
}
