package leetcode.daily_challenge.may_to_july_24.equal_substring;

import java.util.Arrays;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] distance = new int[s.length()];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int counter = 0;
        int substringCost = 0;
        int left = 0;
        int right = 0;
        while (left < distance.length) {
            if (right < left) {
                right = left;
            }
            while (right < distance.length) {
                if (substringCost + distance[right] <= maxCost) {
                    substringCost += distance[right];
                    right++;
                } else {
                    if (left < right) {
                        substringCost -= distance[left];
                    }
                    break;
                }

            }
            counter = counter < (right - left) ? (right - left) : counter;
            left++;
        }
        return counter;
    }
}
