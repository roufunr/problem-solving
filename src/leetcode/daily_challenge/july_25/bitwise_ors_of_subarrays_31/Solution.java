package leetcode.daily_challenge.july_25.bitwise_ors_of_subarrays_31;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // this is a brute force solution
    // it has O(n^3) time complexity
    // where n is the length of the input array
    // it is not efficient for large inputs
    // but it is simple and easy to understand
    // it calculates the bitwise OR for all subarrays
    // and stores the unique results in a set
    // finally, it returns the size of the set
    public int subarrayBitwiseORs_v0(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                int subOR = 0;
                for(int k = i; k <= j; k++) {
                    subOR |= arr[k];
                }
                set.add(subOR);
            }
        }
        return set.size();
    }

    private int getOR(int[] count) {
        int subOR = 0;
        int multiplier = 1;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                subOR += multiplier;
            }
            multiplier *= 2;
        }
        return subOR;
    }

    // this is n^2 solution
    public int subarrayBitwiseORs(int[] arr) {
        int[][] count = new int[arr.length][31];
        int[] sumCount = new int[31];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int idx = 0;
            while(x != 0) {
                sumCount[idx] += x % 2;
                x /= 2;
                idx++;
            }
            for(int k = 0; k < 31; k++) {
                count[i][k] = sumCount[k];
            }
        }
        for(int i = 0; i < arr.length; i++) {
            set.add(getOR(count[i]));
            for(int j = 0; j < i; j++) {
                int[] tempCount = new int[31];
                for(int k = 0; k < 31; k++) {
                    tempCount[k] = count[i][k] - count[j][k];
                }
                set.add(getOR(tempCount));
            }
        }
        return set.size();
    }
}
