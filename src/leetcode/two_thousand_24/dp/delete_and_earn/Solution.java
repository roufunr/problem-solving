package leetcode.two_thousand_24.dp.delete_and_earn;

import java.util.*;

public class Solution {
    private int fn(HashMap<Integer, Integer> map) { // simple backtracking solution
        if (map.size() == 1) {
            Set<Integer> keySet = map.keySet();
            int total = 0;
            for (int key : keySet) {
                total += key * map.get(key);
            }
            return total;
        }
        Set<Integer> keySet = map.keySet();
        int[] keys = new int[keySet.size()];
        int i = 0;
        for (Integer k : keySet) {
            keys[i] = k;
            i++;
        }
        int max = Integer.MIN_VALUE;
        for (i = 0; i < keys.length; i++) {
            int k = keys[i];
            int[][] ks = {
                    { k, map.get(k) },
                    { k - 1, map.getOrDefault(k - 1, 0) },
                    { k + 1, map.getOrDefault(k + 1, 0) }
            };
            if (map.get(k) == 1) {
                map.remove(k);
            } else {
                map.put(k, map.get(k) - 1);
            }
            map.remove(k - 1);
            map.remove(k + 1);
            int f = fn(map) + k;
            max = max < f ? f : max;
            map.put(ks[0][0], ks[0][1]);
            if (ks[1][1] != 0)
                map.put(ks[1][0], ks[1][1]);
            if (ks[2][1] != 0)
                map.put(ks[2][0], ks[2][1]);
        }
        return max;
    }

    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        return fn(count);
    }
}