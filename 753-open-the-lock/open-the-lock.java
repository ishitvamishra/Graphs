class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> vis = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        if(dead.contains("0000")) return -1;

        q.offer("0000");
        vis.add("0000");

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){
                String curr =  q.poll();

                if(curr.equals(target)) return steps;

                for(String next : neighbour(curr)){

                    if(!dead.contains(next) && !vis.contains(next)){
                        q.offer(next);
                        vis.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private List<String> neighbour(String curr){
        List<String> result = new ArrayList<>();
        char arr[] = curr.toCharArray();

        for(int i = 0; i < 4; i++){
            char ch = arr[i];

            //forward
            arr[i] = (char)((ch - '0' + 1) % 10 + '0');
            result.add(new String(arr));

            //backward
            arr[i] = (char)((ch - '0' + 9) % 10 + '0');
            result.add(new String(arr));

            arr[i] = ch;
        }
        return result;
    }
}