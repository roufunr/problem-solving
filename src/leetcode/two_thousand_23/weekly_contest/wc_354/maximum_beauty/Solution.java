package leetcode.two_thousand_23.weekly_contest.wc_354.maximum_beauty;

import java.util.Arrays;

public class Solution {
    private int findMaxOverlaps(int[][] pairs) {
        int n = pairs.length;
        int[] startPoints = new int[n];
        int[] endPoints = new int[n];

        for (int i = 0; i < n; i++) {
            startPoints[i] = pairs[i][0];
            endPoints[i] = pairs[i][1];
        }

        Arrays.sort(startPoints);
        Arrays.sort(endPoints);

        int currentOverlap = 0;
        int maxOverlap = 0;
        int startPtr = 0;
        int endPtr = 0;

        while (startPtr < n) {
            if (startPoints[startPtr] <= endPoints[endPtr]) {
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                startPtr++;
            } else {
                currentOverlap--;
                endPtr++;
            }
        }

        return maxOverlap;
    }
    public int maximumBeauty(int[] nums, int k) {
        // unsolved
        int[][] pairs = new int[nums.length][2];
        int itr = 0;
        for(int n : nums) {
            int[] pair = {n - k, n + k};
            pairs[itr] = pair;
        }
        int maxOverlaps = findMaxOverlaps(pairs);
        return maxOverlaps;
    }

}
