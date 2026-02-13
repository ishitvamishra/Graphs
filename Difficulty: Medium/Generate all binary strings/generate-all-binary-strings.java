class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        generate(n, "", res);
        Collections.sort(res);
        return res;
    }
    private void generate(int n, String curr, ArrayList<String> res){
        if(curr.length() == n){
            res.add(curr);
            return;
        }

        generate(n, curr+"1", res);
        generate(n, curr+"0", res);
    }
}
