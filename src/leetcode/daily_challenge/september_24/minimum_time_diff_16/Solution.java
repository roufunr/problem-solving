package leetcode.daily_challenge.september_24.minimum_time_diff_16;

import java.util.*;

public class Solution {

    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        for (String time : timePoints) {
            int min = Integer.parseInt(time.substring(0, 2)) * 60 +
                    Integer.parseInt(time.substring(3));
            if (minutes[min])
                return 0;
            minutes[min] = true;
        }
        int prevIndex = Integer.MAX_VALUE;
        int firstIndex = Integer.MAX_VALUE;
        int lastIndex = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 24 * 60; i++) {
            if (minutes[i]) {
                if (prevIndex != Integer.MAX_VALUE) {
                    ans = Math.min(ans, i - prevIndex);
                }
                prevIndex = i;
                if (firstIndex == Integer.MAX_VALUE) {
                    firstIndex = i;
                }
                lastIndex = i;
            }
        }

        return Math.min(ans, 24 * 60 - lastIndex + firstIndex);
    }
}