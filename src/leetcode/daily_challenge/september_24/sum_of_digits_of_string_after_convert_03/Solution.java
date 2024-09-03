package leetcode.daily_challenge.september_24.sum_of_digits_of_string_after_convert_03;

public class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            int val = c - 'a' + 1;
            sb.append("" + val);
        }
        int total = 0;
        for(int i = 0; i < sb.length(); i++) {
            total += sb.charAt(i) - '0';
        }
        for(int j = 0; j < k - 1; j++) {
            sb = new StringBuilder("" + total);
            int newTotal = 0;
            for(int i = 0; i < sb.length(); i++) {
                newTotal += sb.charAt(i) - '0';
            }
            total = newTotal;
        }
        return total;
    }
}