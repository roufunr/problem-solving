package leetcode.daily_challenge.find_the_city;

public class Runner {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int distanceThreshold = 2;
        new Solution().findTheCity(n, edges, distanceThreshold);
    }
}
