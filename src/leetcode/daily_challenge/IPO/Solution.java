package leetcode.daily_challenge.IPO;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Comparator<Pair> maxComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p2.second, p1.second);
            }
        };
        Comparator<Pair> minComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.first, p2.first);
            }
        };
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(minComparator);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(maxComparator);
        for (int i = 0; i < capital.length; i++) {
            Pair pair = new Pair(capital[i], profits[i]);
            minHeap.add(pair);
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().first <= w) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.peek().second;
            maxHeap.poll();
        }
        return w;
    }
}
