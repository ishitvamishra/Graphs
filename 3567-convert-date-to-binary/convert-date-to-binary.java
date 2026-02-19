class Solution {
    public String convertDateToBinary(String date) {
        String str ="";
        String year = date.substring(0, 4);
        int num = Integer.parseInt(year);
        String binary = Integer.toBinaryString(num);
        str += binary+"-";

        String month = date.substring(5, 7);
        num = Integer.parseInt(month);
        binary = Integer.toBinaryString(num);
        str += binary+"-";

        String day = date.substring(8, 10);
        num = Integer.parseInt(day);
        binary = Integer.toBinaryString(num);
        str += binary;

        return str;
    }
}