class State{
    int city;
    int cost;
    int time;

    State(int city, int cost, int time){
        this.city = city;
        this.cost = cost;
        this.time = time;
    }
}

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        //Build adj list
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        //Apply simple dijkstras algorithm, just one thing  to take care that an additional 
        //parameter of cost is also added so we well need to carry that as well 
        PriorityQueue<State> pq = new PriorityQueue<>((x,y) -> x.cost - y.cost);
        int minTime[] = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        pq.add(new State(0, passingFees[0], 0));
        minTime[0] = 0;

        while(!pq.isEmpty()){
            int city = pq.peek().city;
            int cost = pq.peek().cost;
            int time = pq.peek().time;
            pq.remove();

            if(city == n-1) return cost;  //dest reached, return cost

            for(int[] it : adj.get(city)){
                int nextCity = it[0];
                int travelTime = it[1];
                int newTime = time + travelTime;

                if(newTime > maxTime) continue; //constraint voilation

                if(newTime < minTime[nextCity]){
                    minTime[nextCity] = newTime;
                    pq.add(new State(nextCity, cost + passingFees[nextCity], newTime));
                }
            }
        }
        return -1;
    }
}