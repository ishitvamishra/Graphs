class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                start += board[i][j];
            }
        }

        int[][] moves = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();

        q.add(start);
        vis.add(start);
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){

                String curr = q.poll();
                if(curr.equals(target)) return steps;

                int zeroIndex = curr.indexOf('0');

                for(int next : moves[zeroIndex]){
                    char[] arr = curr.toCharArray();

                    char temp = arr[zeroIndex];
                    arr[zeroIndex] = arr[next];
                    arr[next] =  temp;

                    String s = new String(arr);

                    if(!vis.contains(s)){
                        q.add(s);
                        vis.add(s);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}