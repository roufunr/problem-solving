package leetcode.queue_stack.moving_average;

public class MovingAverage {
    private int size;
    private int head;
    private int nextCount;
    private int windowSum;
    private int[] queue;
    public MovingAverage(int size) {
        this.size = size;
        queue = new int[size];
        head = 0;
        windowSum = 0;
        nextCount = 0;
    }

    public double next(int val) {
        nextCount++;
        int tailIdx = (head + 1) % size;
        windowSum = windowSum - queue[tailIdx] + val;
        head = (head + 1) % size;
        queue[head] = val;
        return windowSum / (Math.min(size, nextCount) * 1.0);
    }
}
