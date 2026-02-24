class Solution {
    
    public ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj, boolean[] present) {
        int[] indegree = new int[V];
        
        // compute indegree
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        // queue for nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(present[i] && indegree[i] == 0){   // 🔧 only present chars
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return topo;
    }
    
    public String findOrder(String[] words) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<>());
        }
        
        boolean[] present = new boolean[26];   // 🔧 track used chars
        
        // mark present characters
        for(String word : words){
            for(char c : word.toCharArray()){
                present[c - 'a'] = true;
            }
        }
        
        // build graph
        for(int i = 0; i < words.length-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            
            // 🔧 prefix invalid case
            if(s1.length() > s2.length() && s1.startsWith(s2)){
                return "";
            }
            
            int len = Math.min(s1.length(), s2.length());
            
            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a')
                       .add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        ArrayList<Integer> topo = topoSort(26, adj, present);
        
        // 🔧 count present characters
        int countPresent = 0;
        for(boolean b : present){
            if(b) countPresent++;
        }
        
        // 🔧 cycle check
        if(topo.size() != countPresent){
            return "";
        }
        
        String ans = "";
        for(int it : topo){
            ans += (char)(it + 'a');
        }
        
        return ans;
    }
}