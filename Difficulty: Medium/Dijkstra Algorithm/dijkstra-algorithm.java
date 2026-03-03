class Pair{
    int node;
    int dist;
    
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        int[] dis = new int[V];
        for(int i = 0; i < V; i++){
            dis[i] = (int)1e9;
        }
        
        dis[src] = 0;
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            
            for(Pair it : adj.get(node)){
                int v = it.node;
                int w = it.dist;
                
                if(dist + w < dis[v]){
                    dis[v] = dist + w;
                    pq.add(new Pair(v, dis[v]));
                }
            }
        }
        return dis;
    }
}