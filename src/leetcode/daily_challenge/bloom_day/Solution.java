package leetcode.daily_challenge.bloom_day;

import java.util.*;

public class Solution {

    // Calculate the number of bouquets that can be made by day 'mid'.
    private int calculateBouquets(int[] bloomDay, int mid, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= mid) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0;
        int right = 0;
        for (int day : bloomDay) {
            if (day > right) {
                right = day;
            }
        }

        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (calculateBouquets(bloomDay, mid, k) >= m) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
