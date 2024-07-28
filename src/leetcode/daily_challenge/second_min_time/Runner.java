package leetcode.daily_challenge.second_min_time;

public class Runner {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 }, { 4, 5 } };
        int time = 3;
        int change = 5;
        new Solution().secondMinimum(n, edges, time, change);
    }
}
