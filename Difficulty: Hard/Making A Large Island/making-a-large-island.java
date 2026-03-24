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
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public boolean isValid(int adjr, int adjc, int n){
        return adjr >= 0 && adjc >= 0  && adjr < n && adjc < n;
    }
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        //Build Disjoint set
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0) continue;

                for(int ind = 0; ind < 4; ind++){
                    int nr = row + dx[ind];
                    int nc = col + dy[ind];

                    if(isValid(nr, nc, n) && grid[nr][nc] == 1){
                        int nodeNo = row * n + col;
                        int adjNo = nr * n + nc;
                        ds.unionBySize(nodeNo, adjNo);
                    }
                }
            }
        }

        //navigate 0's and look for their neighbouring connected components by tracking 1's
        int mx = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1) continue;

                HashSet<Integer> components = new HashSet<>();
                for(int ind = 0; ind < 4; ind++){
                    int nr = row + dx[ind];
                    int nc = col + dy[ind];
                    
                    //Whenever a components member is found put its Utm in set to avoid redundant components    
                    if(isValid(nr, nc, n) && grid[nr][nc] == 1){
                        components.add(ds.findUPar(nr * n + nc));
                    }
                }
                
                //cal total size
                int totSize = 0;
                for(Integer parent : components){
                    totSize += ds.size[parent];
                }

                mx  = Math.max(mx, totSize + 1);
            }
        }

        //Edge Case : if all are 1s then we need to find utm and return its size  
        //otherwise in that case it will return 0 as value of mx
        for(int cell = 0; cell < n * n; cell++){
            mx = Math.max(mx, ds.size[ds.findUPar(cell)]);
        }

        return mx;
        
    }
}
