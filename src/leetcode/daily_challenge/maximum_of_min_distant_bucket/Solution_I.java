package leetcode.daily_challenge.maximum_of_min_distant_bucket;

import java.util.*;

public class Solution_I {
    // linear search better compared to binary search
    private int nextBucket(int[] positions, int start, int val) {
        int end = positions.length;
        int i = start;
        for (; i < end; i++) {
            if (positions[i] >= val) {
                return i;
            }
        }
        if (i == end) {
            return -1;
        } else {
            return i;
        }
    }

    private boolean canPlaceAllBalls(int[] positions, int minDistance, int totalBalls) {
        int currentBucketIdx = 0;
        for (int i = 1; i < totalBalls; i++) {
            currentBucketIdx = nextBucket(positions, currentBucketIdx + 1, positions[currentBucketIdx] + minDistance);
            if (currentBucketIdx == -1) {
                return false;
            }
        }
        return true;
    }

    public int maxDistance(int[] positions, int m) {
        Arrays.sort(positions);
        int start = 1;
        int end = positions[positions.length - 1] - positions[0];
        int minD = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canPlaceAllBalls(positions, mid, m)) {
                minD = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return minD;
    }
}