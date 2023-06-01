package leetcode.heap.last_stone_weight;

import java.util.Collections;
import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4085/
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() >= 2) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if(stone1 == stone2) {
                //do nothing
            } else {
                maxHeap.add(Math.abs(stone1 - stone2));
            }
        }

        return maxHeap.size() == 1 ? maxHeap.peek() : 0;
    }
}
