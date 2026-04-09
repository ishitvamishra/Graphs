class Solution {
    public String getHint(String secret, String guess) {
        int[] sCount = new int[10];
        int[] gCount = new int[10];

        int bulls = 0, cows = 0;

        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            else{
                sCount[secret.charAt(i) - '0']++;
                gCount[guess.charAt(i) - '0']++;

            }
        }
        
        for(int i =  0; i < 10; i++){
            cows += Math.min(sCount[i], gCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}