package leetcode.top150.length_of_last_word_16;

public class Solution {
    public int lengthOfLastWord(String s) {
        int counter = 0;
        boolean foundChar = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                foundChar = true;
                counter++;
                continue;
            }
            if (foundChar == true && s.charAt(i) != ' ') {
                counter++;
                continue;
            }
            if (foundChar == true && s.charAt(i) == ' ') {
                break;
            }
        }
        return counter;
    }
}