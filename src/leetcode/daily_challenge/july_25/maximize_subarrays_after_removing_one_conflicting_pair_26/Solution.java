package leetcode.daily_challenge.july_25.maximize_subarrays_after_removing_one_conflicting_pair_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        @SuppressWarnings("unchecked")
        List<Integer>[] minConflict = new ArrayList[n + 1];
        for(int i = 0; i < minConflict.length; i++) {
            minConflict[i] = new ArrayList<>();
        }
        for(int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]);
            int b = Math.max(pair[0], pair[1]);
            minConflict[b].add(a);
        }

        long[] closestConflict = {0, 0};
        long result = 0;
        long[] bonus = new long[n + 1];
        for(int r = 1; r <= n; r++) {
            for(int maxCon : minConflict[r]) {
                if(maxCon > closestConflict[0]) {
                    closestConflict[1] = closestConflict[0];
                    closestConflict[0] = maxCon;
                } else if(maxCon > closestConflict[1]) {
                    closestConflict[1] =  maxCon;
                }
            }
            result += r - closestConflict[0];
            if(closestConflict[0] > 0) {
                bonus[(int)closestConflict[0]] += closestConflict[0] - closestConflict[1]; 
            }
        }
        long maxBonus = 0;
        for(long bon : bonus) {
            maxBonus = Math.max(bon, maxBonus);
        }
        return result + maxBonus;
    }
}
