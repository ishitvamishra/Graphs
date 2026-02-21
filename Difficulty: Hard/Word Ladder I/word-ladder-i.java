class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int wordLadderLength(String startWord, String targetWord,String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        
        q.add(new Pair(startWord, 1));
        for(int i = 0; i < wordList.length; i++){
            wordSet.add(wordList[i]);
        }
        
        wordSet.remove(startWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.remove();
            
            if(word.equals(targetWord)) return step;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replacedArray[] = word.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);
                    if(wordSet.contains(replacedWord)){
                        wordSet.remove(replacedWord);
                        q.add(new Pair(replacedWord, step+1));
                    }
                }
            }
        }
        return 0;
    }
}