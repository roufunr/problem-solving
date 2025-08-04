package leetcode.daily_challenge.august_25.fruits_into_baskets_04;

import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(left <= right && map.size() > 2) {
                if(map.get(fruits[left]) == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }
        return maxLen;
    }
}
