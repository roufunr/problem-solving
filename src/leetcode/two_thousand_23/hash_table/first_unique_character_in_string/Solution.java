package leetcode.two_thousand_23.hash_table.first_unique_character_in_string;

import java.util.*;

public class Solution {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(map.containsKey(c) ) {
                map.put(c,Integer.MAX_VALUE);
            } else {
                map.put(c, i);
            }
        }
        int minIdx = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(minIdx > entry.getValue()) {
                minIdx = entry.getValue();
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}