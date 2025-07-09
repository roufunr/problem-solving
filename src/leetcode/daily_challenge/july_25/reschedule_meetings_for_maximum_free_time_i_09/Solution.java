package leetcode.daily_challenge.july_25.reschedule_meetings_for_maximum_free_time_i_09;

public class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] prefixSum = new int[startTime.length + 1];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int lastEnd = 0;
        for(int i = 0; i < startTime.length; i++) {
            sum += (startTime[i] - lastEnd);
            prefixSum[i] = sum;
            if(i - k - 1 >= 0) {
                max = Math.max(prefixSum[i] - prefixSum[i - k - 1], max);
            } else {
                max = Math.max(prefixSum[i], max);
            }
            lastEnd = endTime[i];
        }
        sum += (eventTime - lastEnd);
        prefixSum[startTime.length] = sum;
        if(startTime.length - k - 1 >= 0) {
            max = Math.max(prefixSum[startTime.length] - prefixSum[startTime.length - k - 1], max);
        } else {
            max = Math.max(prefixSum[startTime.length], max);
        }
        return max;
    }
}