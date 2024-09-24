package leetcode.daily_challenge.september_24.extra_characters_in_a_string_23;
import java.util.*;
public class Solution {
    private Set<String> words; 
    private Integer[] cache;
    public int dp(String s, int startIdx) {
        if(startIdx >= s.length()) {
            return 0;
        }
        if(cache[startIdx] != null) {
            return cache[startIdx];
        }
        int remainingCharCount = Integer.MAX_VALUE;
        for(int i = startIdx; i < s.length(); i++) {
            String substring = s.substring(startIdx, i + 1);
            if(words.contains(substring)) {
                remainingCharCount = Math.min(remainingCharCount, dp(s, i + 1));
            } else {
                remainingCharCount = Math.min(substring.length() + dp(s, i + 1), remainingCharCount);
            }
        }
        cache[startIdx] = remainingCharCount;
        return remainingCharCount;
    } 
    public int minExtraChar(String s, String[] dictionary) {
        words = new HashSet<>();
        cache = new Integer[s.length()];
        for(String dict : dictionary) {
            words.add(dict);
        }
        return dp(s, 0);
    }
}