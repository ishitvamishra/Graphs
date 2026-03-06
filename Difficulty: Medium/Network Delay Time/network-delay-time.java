class Pair{
    int v;
    int w;

    Pair(int v, int w){
        this.v = v;
        this.w = w;
    }
}

class State{
    int node;
    int time;

    State(int node, int time){
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int findDelayTime(int n, int[][] times, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Pair(v,w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);

        PriorityQueue<State> pq = new PriorityQueue<>((x,y) -> x.time - y.time);

        pq.add(new State(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            int time = pq.peek().time;
            int node = pq.peek().node;
            pq.remove();

            if(time > dist[node]) continue;

            for(Pair it : adj.get(node)) {
                int adjNode = it.v;
                int wt = it.w;

                if(dist[adjNode] > time + wt) {
                    dist[adjNode] = time + wt;
                    pq.add(new State(adjNode, dist[adjNode]));
                }
            }
        }

        // Step 5: find max
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(dist[i] == (int)1e9) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}