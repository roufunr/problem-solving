package leetcode.daily_challenge.april_25.rabbits_in_forest_20;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int rabbit : answers) {
            map.put(rabbit, map.getOrDefault(rabbit, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int m = entry.getKey();
            int n = entry.getValue();
            // System.out.println(m + "->" + n);
            if(m + 1 >= n) {
                count += (m + 1);
            } else if(m + 1 < n) {
                int q = n / (m + 1);
                int r = n % (m + 1) > 0 ? 1 : 0;
                count += (q + r) * (m + 1);
            }
        }
        return count;
    }
}