package leetcode.daily_challenge.october_24.check_if_array_pairs_are_divisible_by_k_01;

import java.util.Arrays;

public class Solution {

    private class Comparator implements java.util.Comparator<Integer> {

        private int k;

        public Comparator(int k) {
            this.k = k;
        }

        public int compare(Integer i, Integer j) {
            return ((k + (i % k)) % k) - ((k + (j % k)) % k);
        }
    }

    public boolean canArrange(int[] arr, int k) {
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            array[i] = arr[i];
        }

        Arrays.sort(array, new Comparator(k));

        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] % k != 0)
                break;
            if (array[start + 1] % k != 0)
                return false;
            start = start + 2;
        }

        while (start < end) {
            if ((array[start] + array[end]) % k != 0)
                return false;
            start++;
            end--;
        }
        return true;
    }
}