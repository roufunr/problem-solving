package lc_others.sum_of_values_at_indices_with_k_set_bits;

import java.util.*;
public class Solution {
    private int getSetBitsCount(int n) {
        int count = 0;
        int N = n;
        while (N > 0) {
            count += (N % 2);
            N = N / 2;
        }
        // System.out.println(n + " -> " + count);
        return count;
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (getSetBitsCount(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }
}