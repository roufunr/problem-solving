package leetcode.random.random_exercise.k_closest_point_to_origin;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    public int[] point;
    public double distance;
    public Pair(int[] point, double distance) {
        this.point = new int[2];
        this.point[0] = point[0];
        this.point[1] = point[1];
        this.distance = distance;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingDouble(p -> p.distance));
        for(int[] point : points) {
            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            System.out.println(distance);
            Pair pair = new Pair(point, distance);
            queue.offer(pair);
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++;) {
            ans[i] = queue.poll().point;
        }
        return ans;
    }
}
