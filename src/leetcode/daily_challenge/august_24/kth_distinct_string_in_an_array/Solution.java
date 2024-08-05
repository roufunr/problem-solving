package leetcode.daily_challenge.kth_distinct_string_in_an_array;

import java.util.*;

public class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int kth = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                kth++;
                if (kth == k) {
                    return arr[i];
                }
            }
        }
        return "";
    }
}