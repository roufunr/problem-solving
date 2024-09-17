package leetcode.top150.roman_to_integer_16;

import java.util.*;

public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> romanSymbolToValMap = new HashMap<>();
        romanSymbolToValMap.put("I", 1);
        romanSymbolToValMap.put("V", 5);
        romanSymbolToValMap.put("X", 10);
        romanSymbolToValMap.put("L", 50);
        romanSymbolToValMap.put("C", 100);
        romanSymbolToValMap.put("D", 500);
        romanSymbolToValMap.put("M", 1000);

        romanSymbolToValMap.put("IV", 4);
        romanSymbolToValMap.put("IX", 9);
        romanSymbolToValMap.put("XL", 40);
        romanSymbolToValMap.put("XC", 90);
        romanSymbolToValMap.put("CD", 400);
        romanSymbolToValMap.put("CM", 900);

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanSymbolToValMap.get(s.substring(i, i + 2)) != null) {
                num += romanSymbolToValMap.get(s.substring(i, i + 2));
                i++;
            } else {
                num += romanSymbolToValMap.get(s.substring(i, i + 1));
            }
        }
        return num;
    }
}