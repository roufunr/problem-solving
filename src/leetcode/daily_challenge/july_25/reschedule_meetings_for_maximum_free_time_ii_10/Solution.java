package leetcode.daily_challenge.july_25.reschedule_meetings_for_maximum_free_time_ii_10;

public class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int leftMax = 0;
        int rightMax = 0;
        int n = startTime.length;
        boolean[] nonAdjacentMaxExist = new boolean[startTime.length];
        for(int i = 0; i < n; i++) {
            if(leftMax >= (endTime[i] - startTime[i])) {
                nonAdjacentMaxExist[i] = true;
            }
            leftMax = Math.max(leftMax, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));
            int k = n - i - 1; // decreasing
            if(rightMax >= (endTime[k] - startTime[k])) {
                nonAdjacentMaxExist[k] = true;
            }
            rightMax = Math.max(rightMax, (k == n - 1 ? eventTime : startTime[k + 1]) - endTime[k]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int left = (i == 0 ? 0 : endTime[i -1]);
            int right = (i == n - 1 ? eventTime : startTime[i + 1]);
            if(nonAdjacentMaxExist[i]) {
                ans = Math.max(ans, right - left);
            } else {
                ans = Math.max(ans, right - left - (endTime[i] - startTime[i]));
            }
        }
        return ans;
    }
}
