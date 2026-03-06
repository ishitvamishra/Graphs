class Pair {
    int node;
    long dist;

    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        long[] distance = new long[n];
        int[] ways = new int[n];
        int mod = (int)(1e9 + 7);

        Arrays.fill(distance, Long.MAX_VALUE);

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dist, b.dist));
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int node = cur.node;
            long dist = cur.dist;

            if(dist > distance[node]) continue;

            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                long wt = it.dist;

                if(dist + wt < distance[adjNode]){
                    distance[adjNode] = dist + wt;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                    ways[adjNode] = ways[node];
                }
                else if(dist + wt == distance[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}