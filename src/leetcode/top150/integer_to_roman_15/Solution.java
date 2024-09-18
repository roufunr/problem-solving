package leetcode.top150.integer_to_roman_15;

import java.util.*;

class Solution {
    private Map<Integer, String> map;

    public Solution() {
        map = new HashMap<>();
        map.put(0, "");
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 8; j++) {
                StringBuilder sb = new StringBuilder();
                if (j >= 1 && j <= 3) {
                    for (int k = 0; k < j; k++) {
                        sb.append(map.get((int) Math.pow(10, i)));
                    }
                } else if (j >= 6 && j <= 8) {
                    sb.append(map.get((int) (5 * Math.pow(10, i))));
                    for (int k = 0; k < j - 5; k++) {
                        sb.append(map.get((int) Math.pow(10, i)));
                    }
                }
                if (sb.length() > 0) {
                    map.put((int) (j * Math.pow(10, i)), sb.toString());
                }
            }
        }
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int positional = 1;
        while (num > 0) {
            int c = num % 10;
            sb.insert(0, map.get(c * positional));
            num /= 10;
            positional *= 10;
        }
        return sb.toString();
    }
}