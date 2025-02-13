package leetcode.daily_challenge.february_25.minimum_operation_to_exceed_threshold_value_ii_13;

import java.util.PriorityQueue;

public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int n : nums) {
            pq.offer((long)n);
        }
        int count = 0;
        while(pq.peek() < k && pq.size() >= 2) {
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(Math.min(x, y) * 2 + Math.max(x, y));
            count++;
        }
        return count;
    }
}