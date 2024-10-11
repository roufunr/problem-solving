package leetcode.daily_challenge.october_24.the_number_of_the_smallest_unoccupied_chair_11;

import java.util.Arrays;

public class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        int n = times.length;
        int[] chairTime = new int[n];

        for (int[] time : times) {
            for (int i = 0; i < n; i++) {
                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, targetTime)) return i;
                    break;
                }
            }
        }
        return 0;
    }
}