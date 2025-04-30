package leetcode.random.random_exercise.longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = Integer.MIN_VALUE;
        while(start < s.length()) {
            while(charCountMap.size() <= k + 1 && end < s.length()) {
                charCountMap.put(s.charAt(end), charCountMap.getOrDefault(s.charAt(end), 0) + 1);
                end++;
            }
            maxLen = Math.max(maxLen, end - start - 1);
            if(charCountMap.get(s.charAt(start)) == 1) {
                charCountMap.remove(s.charAt(start));
            } else {
                charCountMap.put(s.charAt(start), charCountMap.get(s.charAt(start)) - 1);
            }
            start++;
        }
        return maxLen;
    }
}
