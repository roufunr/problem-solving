package leetcode.hash_table.intersection_of_two_arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178/
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int n : nums1) {
            if(map1.containsKey(n)) {
                map1.put(n, map1.get(n) + 1);
            } else {
                map1.put(n, 1);
            }
        }

        for(int n : nums2) {
            if(map2.containsKey(n)) {
                map2.put(n, map2.get(n) + 1);
            } else {
                map2.put(n, 1);
            }
        }

        List<Integer> intersection = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(map2.containsKey(entry.getKey())) {
                int count = entry.getValue() > map2.get(entry.getKey()) ? map2.get(entry.getKey()) : entry.getValue();
                for(int i = 0; i < count; i++) {
                    intersection.add(entry.getKey());
                }
            }
        }

        int[] ans = new int[intersection.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = intersection.get(i);
        }
        return ans;
    }
}
