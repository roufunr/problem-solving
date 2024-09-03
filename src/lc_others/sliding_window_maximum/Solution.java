package lc_others.sliding_window_maximum;

import java.util.*;
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxs = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.pollLast();
            }
            deque.offerLast(r);
            if(l > deque.peekFirst()) {
                deque.pollFirst();
            }
            if(r - l == k - 1) {
                maxs[l++] = nums[deque.peekFirst()];
            }
        }
        return maxs;
    }
}