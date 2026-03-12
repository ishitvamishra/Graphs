class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        //numbers increasing order me reveal krna h 
        Arrays.sort(deck);

        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[deck.length];

        //queue stores indices and will be traversed in such a way that it gives indices in fixed order of 
        //0,2,4,6,3,1,5 as per question
        for(int i = 0; i < deck.length; i++){
            q.add(i);
        }

        int i = 0;
        while(!q.isEmpty()){
            int idx = q.poll();

            res[idx] = deck[i++];

            if(!q.isEmpty()){
                int next = q.poll();
                q.add(next);
            }
        }
        return res;
    }
}