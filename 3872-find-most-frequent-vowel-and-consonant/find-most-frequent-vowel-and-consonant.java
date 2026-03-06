class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int v = 0;
        int c = 0;

        for(char ch : map.keySet()){
            int freq = map.get(ch);

            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                v = Math.max(v,freq);
            }else{
                c = Math.max(c,freq);
            }
        }
        return c + v;
    }
}