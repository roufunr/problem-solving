package leetcode.daily_challenge.october_24.maximal_score_after_applying_k_operations_14;

import java.util.*;

public class Solution {

    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        // Create a max-heap to store the elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Collections.reverseOrder());

        for (int i : nums) {
            pq.add(i);
        }

        while (k-- > 0) {
            // Add the maxElement in ans and push its one-third value in the
            // priority queue
            int maxElement = pq.poll();
            ans += maxElement;
            pq.add((int) Math.ceil(maxElement / 3.0));
        }
        return ans;
    }
}