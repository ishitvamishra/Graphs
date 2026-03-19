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
    public int removeStones(int[][] stones) {

        int n = stones.length;
        int maxRow = 0, maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        HashSet<Integer> set = new HashSet<>();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;

            ds.unionBySize(row, col);

            set.add(row);
            set.add(col);
        }

        int components = 0;

        for (int node : set) {
            if (ds.findUPar(node) == node) {
                components++;
            }
        }

        return n - components;
    }
}