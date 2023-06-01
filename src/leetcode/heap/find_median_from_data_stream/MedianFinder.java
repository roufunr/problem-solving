package leetcode.heap.find_median_from_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> lowerHalfMaxHeap;
    private PriorityQueue<Integer> upperHalfMinHeap;
//https://leetcode.com/explore/learn/card/heap/646/practices/4092/
    public MedianFinder() {
        lowerHalfMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        upperHalfMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(lowerHalfMaxHeap.isEmpty() || upperHalfMinHeap.isEmpty()) {
            if(lowerHalfMaxHeap.size() == upperHalfMinHeap.size()) {
                lowerHalfMaxHeap.add(num);
            } else {
                if(lowerHalfMaxHeap.peek() >= num) {
                    upperHalfMinHeap.add(lowerHalfMaxHeap.poll());
                    lowerHalfMaxHeap.add(num);
                } else{
                    upperHalfMinHeap.add(num);
                }
            }
        }
        else if (lowerHalfMaxHeap.peek() >= num) {
            if (lowerHalfMaxHeap.size() == upperHalfMinHeap.size()) {
                lowerHalfMaxHeap.add(num);
            } else {
                upperHalfMinHeap.add(lowerHalfMaxHeap.poll());
                lowerHalfMaxHeap.add(num);
            }
        }
        else if (lowerHalfMaxHeap.peek() < num) {
            if (lowerHalfMaxHeap.size() == upperHalfMinHeap.size()) {
                upperHalfMinHeap.add(num);
                lowerHalfMaxHeap.add(upperHalfMinHeap.poll());
            } else {
                upperHalfMinHeap.add(num);
            }
        }
    }

    public double findMedian() {
        if(lowerHalfMaxHeap.size() > upperHalfMinHeap.size()) {
            return lowerHalfMaxHeap.peek();
        } else {
            return (lowerHalfMaxHeap.peek() + upperHalfMinHeap.peek()) / 2.0;
        }
    }
}
