package leetcode.daily_challenge.november_24.largest_combination_with_bitwise_and_greater_than_zero_07;

import java.util.*;

public class Solution {
    public int largestCombination(int[] candidates) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 32; i++) {
            map.put(i, 0);
        }
        for (int n : candidates) {
            int x = n;
            int ith = 0;
            while (x > 0) {
                map.put(ith, map.get(ith) + (x % 2));
                x = x / 2;
                ith++;
            }
        }
        int max = 0;
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, map.get(i));
        }
        return max;
    }
}