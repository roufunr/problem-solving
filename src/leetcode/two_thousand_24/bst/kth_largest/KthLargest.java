package leetcode.two_thousand_24.bst.kth_largest;

import java.util.PriorityQueue;


public class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if(pq.size() >= k) {
            if(val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }
        
        } else {
            pq.add(val);
        }
        
        return pq.peek();
    }
}
