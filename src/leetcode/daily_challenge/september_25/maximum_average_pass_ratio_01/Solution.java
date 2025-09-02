package leetcode.daily_challenge.september_25.maximum_average_pass_ratio_01;

import java.util.PriorityQueue;

class Frac {
    public int n;
    public int d;
    public Frac(int n, int d) {
        this.n = n;
        this.d = d;
    }
    public double gain() {
        return ((n + 1.0) / (d + 1.0)) - ((n * 1.0) / (d * 1.0));
    }
}
public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Frac> pq = new PriorityQueue<>((a, b) -> Double.compare(b.gain(), a.gain())); // max heap
        for(int[] cls : classes) {
            pq.offer(new Frac(cls[0], cls[1]));
        }
        while(extraStudents > 0) {
            Frac head = pq.poll();
            head.n += 1;
            head.d += 1;
            pq.offer(head);
            extraStudents--;
        }
        double sum = 0;
        while(!pq.isEmpty()) {
            Frac head = pq.poll();
            sum += head.n / (head.d * 1.0);
        }
        return sum / classes.length;
    }
}