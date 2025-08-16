package leetcode.daily_challenge.august_25.maximum_69_number_16;

public class Solution {
    public int maximum69Number (int num) {
        StringBuilder str = new StringBuilder("" + num);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '6') {
                str.setCharAt(i, '9'); 
                return Integer.parseInt(str.toString());
            }
        }
        return num;
    }
}
