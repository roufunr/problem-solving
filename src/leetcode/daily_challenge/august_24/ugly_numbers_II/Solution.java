package leetcode.daily_challenge.august_24.ugly_numbers_II;

import java.util.*;

public class Solution {
    private List<Integer> uglyNumberList;

    public Solution() {
        Set<Integer> uglyNumbers = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 14; k++) {
                    long number = (long) (Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k));
                    if (number > Integer.MAX_VALUE) {
                        continue;
                    } else {
                        uglyNumbers.add((int) number);
                    }
                }
            }
        }
        uglyNumberList = new ArrayList<>(uglyNumbers);
        Collections.sort(uglyNumberList);
    }

    public int nthUglyNumber(int n) {
        return uglyNumberList.get(n - 1);
    }
}