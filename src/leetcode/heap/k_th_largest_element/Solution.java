package leetcode.heap.k_th_largest_element;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    //https://leetcode.com/explore/learn/card/heap/646/practices/4014/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : nums) {
            maxHeap.add(n);
        }
        for(int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
