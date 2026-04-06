class Solution {
    public String frequencySort(String s) {
        //Bucket Sort ka use krenge 
        Map<Character, Integer> map = new HashMap<>();

        //map sort nhi hosakta toh buckets banana padega based on freq of letter
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];

        //for each letter uske freq wale bucket pe us letter ko store kra do
        for(char c : map.keySet()){
            int freq = map.get(c);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(c);
        }

        StringBuilder ans = new StringBuilder();

        //Bucket last se traverse kro for descending order
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(char c : bucket[i]){
                    for(int j = 0; j < i; j++){
                        ans.append(c);
                    }
                }
            }
        }

        return ans.toString();
    }
}