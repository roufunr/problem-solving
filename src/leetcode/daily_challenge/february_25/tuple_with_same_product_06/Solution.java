package leetcode.daily_challenge.february_25.tuple_with_same_product_06;

import java.util.*;

public class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int mul = nums[i] * nums[j];
                if (map.containsKey(mul)) {
                    if (!map.get(mul).contains(i) && !map.get(mul).contains(j)) {
                        ans+= (map.get(mul).size()/2);
                    }
                } else {
                    map.put(mul, new HashSet<>());
                }
                map.get(mul).add(i);
                map.get(mul).add(j);
            }
        }
        return ans;
    }
}