package leetcode.daily_challenge.october_24.find_kth_bit_in_nth_binary_string_19;

public class Solution {
    private String invert(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        return sb.toString();
    }
    public char findKthBit(int n, int k) {
        String s = "0";
        int i = 1;
        while(i < n) {
            s = s + "1" + reverse(invert(s));
            i++;
        }
        // System.out.println(s);
        return s.charAt(k - 1);
    }
}