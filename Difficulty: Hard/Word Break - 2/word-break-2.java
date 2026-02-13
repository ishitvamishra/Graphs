class Solution {
    static String[] wordBreak(String[] dict, String s) {
        
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(dict));
        HashMap<Integer, List<String>> wordMap = new HashMap<>();

        List<String> ans = helper(0, s, wordSet, wordMap);

        return ans.toArray(new String[0]);
    }
    
    private static List<String> helper(int start, String s,
                                       HashSet<String> wordSet,
                                       HashMap<Integer, List<String>> wordMap){
        
        if(wordMap.containsKey(start)) 
            return wordMap.get(start);
        
        ArrayList<String> res = new ArrayList<>();

        if(start == s.length()){
            res.add("");
            return res;
        }

        for(int end = start + 1; end <= s.length(); end++){
            String word = s.substring(start, end);

            if(wordSet.contains(word)){
                List<String> subList = helper(end, s, wordSet, wordMap);

                for(String sub : subList){
                    if(sub.equals("")){
                        res.add(word);
                    }else{
                        res.add(word + " " + sub);
                    }
                }
            }
        }

        wordMap.put(start, res);
        return res;
    }
}
