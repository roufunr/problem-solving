package leetcode.daily_challenge.august_24.maximum_distance_in_arrays;

import java.util.*;

class Pair {
    public int val;
    public int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.val, p2.val);
            }
        });
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p2.val, p1.val);
            }
        });
        int idx = 0;
        for (List<Integer> arr : arrays) {
            minHeap.offer(new Pair(arr.get(arr.size() - 1), idx));
            maxHeap.offer(new Pair(arr.get(0), idx));
            if (minHeap.size() > 2) {
                minHeap.poll();
                maxHeap.poll();
            }
            idx++;
        }
        Pair[] min = { maxHeap.poll(), maxHeap.poll() };
        Pair[] max = { minHeap.poll(), minHeap.poll() };
        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (max[i].idx != min[j].idx) {
                    maxDist = Math.max(max[i].val - min[j].val, maxDist);
                }
            }
        }
        return maxDist;
    }
}