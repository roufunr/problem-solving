package leetcode.daily_challenge.november_24.shortest_distance_after_road_addition_queries_I_27;

public class Runner {
    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{2,4},{0,2},{0,4}};
        new Solution().shortestDistanceAfterQueries(n, queries);
    }
}
