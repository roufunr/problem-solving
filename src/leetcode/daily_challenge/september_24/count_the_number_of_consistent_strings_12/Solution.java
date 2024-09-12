package leetcode.daily_challenge.september_24.count_the_number_of_consistent_strings_12;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    count++;
                    break;
                }
            }
        }
        return words.length - count;
    }
}
