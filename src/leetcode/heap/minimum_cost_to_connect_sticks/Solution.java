package leetcode.heap.minimum_cost_to_connect_sticks;

import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4090/
public class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int stick : sticks) {
            minHeap.add(stick);
        }

        int minCost = 0;
        while(minHeap.size() > 1) {
            int topFirst = minHeap.poll();
            int topSecond = minHeap.poll();
            minCost += (topSecond + topFirst);
            minHeap.add(topFirst + topSecond);
        }
        return minCost;
    }
}
