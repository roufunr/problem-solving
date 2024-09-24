package leetcode.daily_challenge.september_24.find_the_length_of_the_longest_common_prefix_24;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int n : arr1) {
            while(n > 0) {
                set.add(n);
                n /= 10;
            }
        }
        int maxLen = 0;
        for(int n : arr2) {
            while(n > 0) {
                if(String.valueOf(n).length() < maxLen) {
                    break;
                }
                if(set.contains(n)) {
                    maxLen = String.valueOf(n).length();
                    break;
                }
                n /= 10;
            }
        }
        return maxLen;
    }
}