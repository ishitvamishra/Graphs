class Pair{
    int first;
    int second;
    
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public void topoSort(int node, int[] vis, Stack<Integer> s, ArrayList<ArrayList<Pair>> adj){
        vis[node] = 1;
        
        for(Pair it : adj.get(node)){
            int v = it.first;
            if(vis[v] == 0){
                topoSort(v, vis, s, adj);
            }
        }
        s.add(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new Pair(v, w));
        }
        
        int[] vis = new int[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                topoSort(i, vis, s, adj);
            }
        }
        
        int[] dist = new int[V];
        
        for(int i = 0; i < V; i++){
            dist[i] = (int)1e9;
        }
        
        dist[0] = 0;
        while(!s.isEmpty()){
            int node = s.pop();
            
            for(Pair it : adj.get(node)){
                int v = it.first;
                int w = it.second;
                
                if(dist[node] + w < dist[v]){
                    dist[v] = dist[node] + w;
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
}