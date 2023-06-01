package leetcode.hash_table.sum_III_4;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1134/
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : nums1) {
            for(int b : nums2) {
                if(map.containsKey(a + b)) {
                    int val = map.get(a+b);
                    val++;
                    map.put(a+b, val);
                } else {
                    map.put(a+b, 1);
                }
            }
        }

        int count = 0;

        for(int c : nums3) {
            for(int d : nums4) {
                int target = (c + d) * (-1);
                if(map.containsKey(target)) {
                    count += map.get(target);
                } else {
                   // do nothing
                }
            }
        }

        return count;
    }
}
