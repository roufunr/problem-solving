package leetcode.daily_challenge.august_24.make_two_arrays_equal;

import java.util.*;

public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int n : target) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        for (int n : arr) {
            if (map1.containsKey(n)) {
                if (map1.get(n) > 1) {
                    map1.put(n, map1.get(n) - 1);
                } else {
                    map1.remove(n);
                }
            }
        }
        return map1.size() == 0;
    }
}