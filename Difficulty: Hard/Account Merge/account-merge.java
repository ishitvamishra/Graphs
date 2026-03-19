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
    public ArrayList<ArrayList<String>> accMerge(String[][] accounts) {

        int n = accounts.length;
        DisjointSet ds = new DisjointSet(n);

        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Union based on common emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts[i].length; j++) {
                String email = accounts[i][j];

                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    ds.unionBySize(i, map.get(email));
                }
            }
        }

        // Step 2: Group emails by parent
        Map<Integer, List<String>> merged = new HashMap<>();

        for (String email : map.keySet()) {
            int parent = ds.findUPar(map.get(email));

            merged.putIfAbsent(parent, new ArrayList<>());
            merged.get(parent).add(email);
        }

        // Step 3: Build result
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        for (int parent : merged.keySet()) {
            List<String> emails = merged.get(parent);
            Collections.sort(emails);

            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts[parent][0]); // name
            temp.addAll(emails);

            res.add(temp);
        }

        return res;
    }
}