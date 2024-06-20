package leetcode.daily_challenge.bloom_day;
public class Solution {

    // Calculate the number of bouquets that can be made by day 'mid'.
    private int countBouquets(int[] bloomDay, int day, int k) {
        int bCount = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                bCount++;
                count = 0;
            }
        }
        return bCount;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int startDay = Integer.MAX_VALUE;
        int endDay = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            if (startDay >= day) {
                startDay = day;
            }
            if (endDay <= day) {
                endDay = day;
            }
        }
        int minDays = -1;
        while (startDay <= endDay) {
            int mid = startDay + (endDay - startDay) / 2;
            if (countBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                endDay = mid - 1;
            } else {
                startDay = mid + 1;
            }
        }
        return minDays;
    }
}
