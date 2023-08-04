package leetcode.two_thousand_23.hash_table.intersection;
import java.util.*;
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int n : nums1) {
            set1.add(n);
        }
        for(int n : nums2) {
            set2.add(n);
        }
        List<Integer> arr = new ArrayList<>();
        for(Integer n : set2) {
            if(set1.contains(n)) {
                arr.add(n);
            }
        }
        int[] ans = new int[arr.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
