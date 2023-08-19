package leetcode.two_thousand_23.hash_table.longest_subtsring_without_repetiton;
import java.util.*;

public class Solution {

    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxSubstringLen = Integer.MIN_VALUE;
        Set<Character> explored = new HashSet<>();
        while(right < s.length()) {
            int windowSize = right - left + 1;
            maxSubstringLen = windowSize > maxSubstringLen ? windowSize : maxSubstringLen;
            if(explored.contains(s.charAt(right))) {
                left = right;
                explored = new HashSet<>();
            } else {
                explored.add(s.charAt(right));
            }
            right++;
        }
        return maxSubstringLen;
    }
}
