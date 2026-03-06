class Pair{
    int v;
    int w;

    Pair(int v, int  w){
        this.v = v;
        this.w = w;
    }
}

class State{
    int stops;
    int node;
    int cost;

    State(int stops, int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            adj.get(u).add(new Pair(v,w));
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(0, src, 0));

        int[] dist = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] =  (int)1e9;
        }

        dist[src] = 0;

        while(!q.isEmpty()){
            int stops = q.peek().stops;
            int node = q.peek().node;
            int cost = q.peek().cost;
            q.remove();

            if(stops > k) continue;

            for(Pair it : adj.get(node)){
                int adjNode = it.v;
                int weight =  it.w;

                if(cost + weight < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + weight;
                    q.add(new State(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }

        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
        
    }
}