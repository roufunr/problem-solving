package leetcode.daily_challenge.average_wait_time;

public class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitTime = 0;
        int prevEndTime = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            if (prevEndTime > customers[i][0]) {
                totalWaitTime += prevEndTime - customers[i][0] + customers[i][1];
                prevEndTime = prevEndTime + customers[i][1];
            } else {
                totalWaitTime += customers[i][1];
                prevEndTime = customers[i][0] + customers[i][1];
            }

        }
        return totalWaitTime / customers.length;
    }
}