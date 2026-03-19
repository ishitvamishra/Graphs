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
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        //Store emails with respactive nodes in map
        HashMap<String, Integer> map = new HashMap<>();

        //union accounts based on common emails
        for(int i = 0; i < n; i++){
            List<String> acc = accounts.get(i);

            for(int j = 1; j < acc.size(); j++){
                String email = acc.get(j);

                if(!map.containsKey(email)){
                    map.put(email, i);
                }
                else{
                    ds.unionBySize(i, map.get(email));
                }
            }
        }  

        //Group emails by parent
        Map<Integer, List<String>> merged =  new HashMap<>();

        //for each email in map, agar vo email ke parent ka koi ultimate parent h toh
        //us parent pe email daal do varna normally email ke parent pe daalo
        for(String email : map.keySet()){
            int parent = ds.findUPar(map.get(email));

            merged.putIfAbsent(parent, new ArrayList<>());
            merged.get(parent).add(email);
        }

        //build result
        List<List<String>> res = new ArrayList<>();
        
        for(int parent : merged.keySet()){
            List<String> emails = merged.get(parent);
            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(parent).get(0)); //name
            temp.addAll(emails);

            res.add(temp);
        }

        return res;
    }
}