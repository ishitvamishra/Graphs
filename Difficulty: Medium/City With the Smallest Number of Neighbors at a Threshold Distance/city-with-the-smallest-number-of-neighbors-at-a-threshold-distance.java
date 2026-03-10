// User function Template for Java

class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = INF;
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        //self dist = 0;
        for(int i = 0; i < n; i++){
            dist[i][i] = 0;
        }

        //floyd warshall to find distance matrix for each node
        for(int k = 0; k < n; k++){
            
            for(int i = 0; i < n; i++){
                
                for(int j = 0; j < n; j++){
                    
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;

        for(int city = 0; city < n; city++){
            int cnt = 0;
            for(int adjCity = 0; adjCity < n; adjCity++){
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }

            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }

        return cityNo;
    }
}
