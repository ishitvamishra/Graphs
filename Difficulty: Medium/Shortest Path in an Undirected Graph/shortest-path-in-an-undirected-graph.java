class Pair{
    int node;
    int dist;
    
    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public List<Integer> shortestPath(int V, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int[] dis = new int[V+1];
        int[] parent = new int[V+1];
        
        for(int i = 0; i <= V; i++){
            dis[i] = (int)1e9;
            parent[i] = i;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        dis[1] = 0;
        pq.add(new Pair(1,0));
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            
            if(dist > dis[node]) continue;
            
            for(Pair it : adj.get(node)){
                int v = it.node;
                int w = it.dist;
                
                if(dist + w < dis[v]){
                    dis[v] = dist + w;
                    parent[v] = node;
                    pq.add(new Pair(v, dis[v]));
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if(dis[V] ==(int)1e9){
            path.add(-1);
            return path;
        }
        
        path.add(dis[V]); //add dist first then path
        
        int node = V;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path.subList(1, path.size()));
        return path;
    }
}