package leetcode.daily_challenge.june_25.minimum_deletions_to_make_string_k_special_21;

import java.util.*;
public class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> counter = new HashMap<>();
        for(char c : word.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        int result = word.length();
        for(int a : counter.values()) {
            int deletedCharacters = 0;
            for(int b : counter.values()) {
                if(a > b) {
                    deletedCharacters += b;
                } else if(a < b) {
                    deletedCharacters += b - (a + k);
                }
            }
            result = Math.min(deletedCharacters, result);
        }
        return result;
    }
}
