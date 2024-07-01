package leetcode.extras.redundant_connection;

public class Runner {
    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        new SolutionII().findRedundantConnection(edges);
    }
}
