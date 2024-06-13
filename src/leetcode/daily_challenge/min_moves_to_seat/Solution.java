package leetcode.daily_challenge.min_moves_to_seat;

import java.util.Arrays;

public class Solution {
    // nlogn sort solution (beats 66%)
    public int minMovesToSeatV0(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }
        return count;
    }

    public void countSort(int[] nums) {
        int[] count = new int[101];
        for (int n : nums) {
            count[n]++;
        }
        int k = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }

    // count sort solution (beats 100%)
    public int minMovesToSeat(int[] seats, int[] students) {
        this.countSort(seats);
        this.countSort(students);
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }
        return count;
    }
}
