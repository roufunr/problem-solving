package leetcode.daily_challenge.august_24.find_k_th_smallest_pair_distance;

import java.util.*;

public class Solution {
    // got MLE
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pq.offer(Math.abs(nums[i] - nums[j]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}