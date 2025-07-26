package leetcode.daily_challenge.july_25.maximize_subarrays_after_removing_one_conflicting_pair_26;

import java.util.Arrays;

public class Solution {

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int[] minConflict = new int[n + 1];
        int[] secondMinConflict = new int[n + 1];
        Arrays.fill(minConflict, Integer.MAX_VALUE);
        Arrays.fill(secondMinConflict, Integer.MAX_VALUE);

        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            if (b < minConflict[a]) {
                secondMinConflict[a] = minConflict[a];
                minConflict[a] = b;
            } else if (b < secondMinConflict[a]) {
                secondMinConflict[a] = b;
            }
        }

        long total = 0;
        long[] recoverable = new long[n + 1];
        int currentMinIdx = n;
        int secondBound = Integer.MAX_VALUE;

        for (int i = n; i >= 1; i--) {
            if (minConflict[currentMinIdx] > minConflict[i]) {
                secondBound = Math.min(secondBound, minConflict[currentMinIdx]);
                currentMinIdx = i;
            } else {
                secondBound = Math.min(secondBound, minConflict[i]);
            }

            total += Math.min(minConflict[currentMinIdx], n + 1) - i;

            recoverable[currentMinIdx] +=
                Math.min(Math.min(secondBound, secondMinConflict[currentMinIdx]), n + 1)
                - Math.min(minConflict[currentMinIdx], n + 1);
        }

        long maxRecover = 0;
        for (long val : recoverable) {
            maxRecover = Math.max(maxRecover, val);
        }

        return total + maxRecover;
    }
}
