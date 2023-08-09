package leetcode.two_thousand_23.hash_table.intersection_of_two_array_II;

import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums1) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        List<Integer> intersectionList = new ArrayList<>();
        for(int n : nums2) {
            if(map.containsKey(n)) {
                int times = map.get(n);
                times--;
                intersectionList.add(n);
                if(times == 0) {
                    map.remove(n);
                }
            }
        }
        int[] ans = new int[intersectionList.size()];
        for(int i = 0; i < intersectionList.size(); i++) {
            ans[i] = intersectionList.get(i);
        }
        return ans;
    }
}