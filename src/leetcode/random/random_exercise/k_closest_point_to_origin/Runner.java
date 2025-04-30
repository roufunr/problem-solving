package leetcode.random.random_exercise.k_closest_point_to_origin;

public class Runner {
    public static void main(String[] args) {
        int[][] points = {{0,1},{1,0}};
        new Solution().kClosest(points, 2);
    }
}
