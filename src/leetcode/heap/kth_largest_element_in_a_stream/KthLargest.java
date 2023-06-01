package leetcode.heap.kth_largest_element_in_a_stream;

import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4016/
public class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int n : nums) {
            minHeap.add(n);
        }
        if(nums.length - k > 0) {
            for(int i = 0; i < nums.length - k; i++) {
                minHeap.poll();
            }
        }

    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() == k + 1) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
