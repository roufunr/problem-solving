package leetcode.daily_challenge.jumbled_number;

import java.util.*;

public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        Comparator<Integer> comp = new Comparator<Integer>() {
            private int convert(int i) {
                if (i == 0) {
                    return mapping[0];
                }
                int newNum = 0;
                int mulp = 1;
                while (i > 0) {
                    newNum += mulp * mapping[(i % 10)];
                    i = i / 10;
                    mulp *= 10;
                }
                return newNum;
            }

            @Override
            public int compare(Integer p1, Integer p2) {
                int j1 = convert(p1);
                int j2 = convert(p2);
                return j1 != j2 ? Integer.compare(j1, j2) : 1;
            }
        };
        Arrays.sort(n, comp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = n[i];
        }
        return nums;
    }
}