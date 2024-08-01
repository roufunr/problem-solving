package leetcode.daily_challenge.may_to_july_24.append_characters;

public class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return tLen - j;
    }
}