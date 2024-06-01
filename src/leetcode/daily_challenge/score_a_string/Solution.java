package leetcode.daily_challenge.score_a_string;

public class Solution {
    public int scoreOfString(String s) {
        int total = 0;
        for (int i = 1; i < s.length(); i++) {
            total += (int) Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return total;
    }
}
