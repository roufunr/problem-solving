package leetcode.random.random_exercise.longest_substring_without_repeating_characters;
import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        while(start < s.length()) {
            while(end < s.length()) {
                if(set.contains(s.charAt(end))) {
                    break;
                } else {
                    set.add(s.charAt(end));
                }
                end++;
            }
            maxLen = Math.max(end - start, maxLen);
            set.remove(s.charAt(start));
            start++;
        }
        return maxLen;
    }
}