package leetcode.daily_challenge.may_to_july_24.minimum_difference;

import java.util.Collections;
import java.util.PriorityQueue;

public class SolutionII { // memory efficient solution
    public int minDifference(int[] nums) {
        if (nums.length < 4) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // max 4 values
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // min 4 values
        for (int n : nums) {
            minHeap.offer(n);
            maxHeap.offer(n);
            if (minHeap.size() > 4) {
                minHeap.poll();
                maxHeap.poll();
            }
        }
        int[] minMax = new int[8];
        for (int i = 0; i < 4; i++) {
            minMax[4 - i - 1] = maxHeap.poll();
            minMax[4 + i] = minHeap.poll();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = minMax.length - 4; i < 4; i++, j++) {
            ans = Math.min(ans, minMax[j] - minMax[i]);
        }
        return ans;
    }
}
