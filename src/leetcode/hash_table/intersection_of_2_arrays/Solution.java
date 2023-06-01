package leetcode.hash_table.intersection_of_2_arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for(int n : nums1) {
            num1Set.add(n);
        }

        Set<Integer> resultSet = new HashSet<>();
        for(int n : nums2) {
            if(num1Set.contains(n)) {
                resultSet.add(n);
            }
        }

        int[] resultArr = new int[resultSet.size()];
        int k = 0;
        for(int n : resultSet) {
            resultArr[k++] = n;
        }
        return resultArr;
    }
}
