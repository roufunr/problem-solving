package leetcode.daily_challenge.march_25.merge_two_2d_arrays_by_summing_values_02;
import java.util.*;
public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] num : nums1) {
            map.put(num[0], num[1]);
        }

        for(int[] num : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        int[][] ans = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[i][0] = entry.getKey();
            ans[i][1] = entry.getValue();
            i++;
        }
        return ans;
    }
}