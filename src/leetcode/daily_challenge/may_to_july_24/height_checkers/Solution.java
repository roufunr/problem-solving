package leetcode.daily_challenge.may_to_july_24.height_checkers;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedHeights = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            sortedHeights[i] = heights[i];
        }
        Arrays.sort(sortedHeights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > sortedHeights[i]) {
                count++;
            }
        }
        return count;
    }
}