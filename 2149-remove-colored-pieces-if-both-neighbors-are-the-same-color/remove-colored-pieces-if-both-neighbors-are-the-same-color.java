class Solution {
    public boolean winnerOfGame(String colors) {
        int consA = 0, consB = 0;
        int chanceA = 0, chanceB = 0;

        for(char ch : colors.toCharArray()){
            if(ch == 'A'){
                consB = 0;
                consA++;
                if(consA >= 3) chanceA++;
            }else{
                consA = 0;
                consB++;
                if(consB >= 3) chanceB++;
            }
        }

        return chanceA > chanceB;
    }
}