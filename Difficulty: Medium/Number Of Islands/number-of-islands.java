class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, 1, 0, -1};
    
    public boolean isValid(int adjr, int adjc, int n, int m){
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
    
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for(int i = 0; i < len; i++){
            int row = operators[i][0];
            int col = operators[i][1];
            
            if(vis[row][col] == 1){
                ans.add(cnt);
                continue;
            }
            
            vis[row][col] = 1;
            cnt++;
            
            //finding neighbour
            for(int ind = 0; ind < 4; ind++){
                int adjr = row + dx[ind];
                int adjc = col + dy[ind];
                
                if(isValid(adjr, adjc, n, m)){
                    if(vis[adjr][adjc] == 1){
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjr * m + adjc;
                        
                        if(ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)){
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}