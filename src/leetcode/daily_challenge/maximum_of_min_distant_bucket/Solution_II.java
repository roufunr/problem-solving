package leetcode.daily_challenge.maximum_of_min_distant_bucket;


public class Solution_II {
    // you can't use count sort because there are memory limit
    private void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = max < n ? n : max;
            min = min > n ? n : min;
        }
        int[] count = new int[max - min + 1];
        for (int n : nums) {
            count[n - min]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            for (int k = 0; k < c; k++) {
                nums[j++] = min + i;
            }
        }
    }

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
        countSort(positions);
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