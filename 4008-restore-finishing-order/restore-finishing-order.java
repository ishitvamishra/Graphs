class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[friends.length];

        for(int num : friends){
            set.add(num);
        }
        
        int j = 0;
        for(int i = 0; i < order.length; i++){
            if(set.contains(order[i])){
                result[j] = order[i];
                j++;
            }
        }
        return result;
    }
}