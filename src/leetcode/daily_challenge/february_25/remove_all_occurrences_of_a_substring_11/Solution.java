package leetcode.daily_challenge.february_25.remove_all_occurrences_of_a_substring_11;

public class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.indexOf(part) >= 0) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
