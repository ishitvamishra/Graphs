//also try DSU solution
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        //sort meetings based on time 
        Arrays.sort(meetings, (a,b) -> a[2] - b[2]);

        boolean[] secret = new boolean[n];
        secret[0] = true;
        secret[firstPerson] = true;

        int i = 0;

        //group all people with same meeting time and make a temporary grph for them
        while(i < meetings.length){

            int time = meetings[i][2];

            Map<Integer, List<Integer>> adj = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while(i < meetings.length && meetings[i][2] == time){

                int x = meetings[i][0];
                int y = meetings[i][1];

                adj.computeIfAbsent(x,k->new ArrayList<>()).add(y);
                adj.computeIfAbsent(y,k->new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);

                i++;
            }

            //start queue traversal on them whoever knows the secret
            Queue<Integer> q = new LinkedList<>();

            for(int p : people){
                if(secret[p]) q.offer(p);
            }

            Set<Integer> vis = new HashSet<>();

            while(!q.isEmpty()){

                int node = q.poll();
                vis.add(node);

                //propagate the secret to nei of the node
                for(int nei : adj.getOrDefault(node,new ArrayList<>())){

                    if(!vis.contains(nei)){

                        secret[nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        //group all the people who knows the secret
        for(int j = 0; j < n; j++){
            if(secret[j]) ans.add(j);
        }

        return ans;
    }
}