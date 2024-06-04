package leetcode.daily_challenge.longest_palindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int result = 0;
        int oddCounter = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                result += (entry.getValue() / 2) * 2;
                oddCounter += 1;
            } else {
                result += entry.getValue();
            }
        }
        if (oddCounter >= 1) {
            result += 1;
        }
        return result;
    }
}