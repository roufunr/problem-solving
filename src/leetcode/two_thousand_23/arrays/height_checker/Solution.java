package leetcode.two_thousand_23.arrays.height_checker;

import java.util.Arrays;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
    public int heightChecker(int[] heights) {
        int[] sortedHeight = new int[heights.length];
        for(int i = 0; i < heights.length; i++) {
            sortedHeight[i] = heights[i];
        }
        Arrays.sort(sortedHeight);
        int misplaced = 0;
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != sortedHeight[i]) {
                misplaced++;
            }
        }
        return misplaced;
    }
}
