package leetcode.daily_challenge.november_24.rotate_string_03;

public class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        StringBuilder rotatedString = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (rotatedString.toString().equals(goal)) {
                return true;
            }
            rotatedString.append(rotatedString.charAt(0));
            rotatedString.deleteCharAt(0);
        }
        return false;
    }
}