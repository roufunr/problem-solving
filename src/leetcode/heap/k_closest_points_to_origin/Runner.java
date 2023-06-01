package leetcode.heap.k_closest_points_to_origin;

public class Runner {
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        new Solution().kClosest(points, k);
    }
}
