package leetcode.heap.meeting_rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4087/
class Interval implements Comparable<Interval> {
    public int[] range;
    public Interval(int[] range) {
        this.range = range;
    }

    @Override
    public int compareTo(Interval o) {
        return this.range[0] - o.range[0];
    }
}
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Interval> startTimeMinHeap = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++) {
            startTimeMinHeap.add(new Interval(intervals[i]));
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 1;
        minHeap.add(startTimeMinHeap.poll().range[1]);
        for(int i = 0; i < intervals.length - 1; i++) {
            int[] range = startTimeMinHeap.poll().range;
            if(minHeap.peek() > range[0]) {
                count++;
            } else {
                minHeap.poll();
            }
            minHeap.add(range[1]);
        }
        return count;
    }
}