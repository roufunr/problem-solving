package leetcode.heap.furthest_building_you_can_reach;

import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4091/
public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> laddersMinHeap = new PriorityQueue<>();
        int count = 0;

        for(int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if(diff <= 0) {
                count++;
                continue;
            } else {
                if(laddersMinHeap.size() < ladders) {
                    laddersMinHeap.add(diff);
                    count++;
                } else {
                    int top = laddersMinHeap.isEmpty() ? -1 : laddersMinHeap.peek();

                    if(top == -1 && bricks >= diff) {
                        bricks -= diff;
                        count++;
                        continue;
                    }
                    else if (top == -1 && bricks < diff) {
                        break;
                    }
                    else {
                        if(top >= diff && bricks >= diff) {
                            bricks -= diff;
                            count++;
                        } else if(top < diff && bricks >= top) {
                            bricks -= top;
                            count++;
                            laddersMinHeap.poll();
                            laddersMinHeap.add(diff);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
