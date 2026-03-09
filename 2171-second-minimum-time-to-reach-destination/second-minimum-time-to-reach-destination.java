class Pair{
    int node;
    int time;

    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n+1][2];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        q.add(new Pair(1, 0));
        dist[1][0] = 0;

        while(!q.isEmpty()){
            int node = q.peek().node;
            int currTime = q.peek().time;
            q.remove();

            for(int next : adj.get(node)){
                int depart = currTime;

                if((depart / change) % 2 == 1){
                    depart  += change - (depart % change);
                }

                int arrival = depart + time;

                if(arrival < dist[next][0]){
                    dist[next][0] = arrival;
                    q.add(new Pair(next, arrival));
                }

                else if(arrival > dist[next][0] && arrival < dist[next][1]){
                    dist[next][1] = arrival;
                    q.add(new Pair(next, arrival));
                }

                if(next == n && dist[next][1] != Integer.MAX_VALUE){
                    return dist[next][1];
                } 
            }
        }
        return -1;
    }
}