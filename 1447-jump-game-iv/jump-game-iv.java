class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        //if only one element
        if(n == 1) return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        //store list of indices for multiple occurence of an element
        for(int i = 0; i < arr.length; i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.add(0);
        vis[0] = true;

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int idx = q.poll();
                
                if(idx == n-1) return steps;

                //Left(i - 1)
                if(idx - 1 >= 0 && !vis[idx - 1]){
                    vis[idx - 1] = true;
                    q.add(idx - 1);
                }

                //Right(i + 1);
                if(idx + 1 < n && !vis[idx + 1]){
                    vis[idx + 1] = true;
                    q.add(idx + 1);
                }

                //Same value
                if(map.containsKey(arr[idx])){
                    for(int next : map.get(arr[idx])){
                        if(!vis[next]){
                            vis[next] = true;
                            q.add(next);
                        }
                    }

                    //Optimization, in order to avoid to and forth jumps 
                    map.remove(arr[idx]);
                }
            }
            steps++;
        }

        return -1;
    }
}