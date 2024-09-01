package leetcode.daily_challenge.august_24.modify_graph_edge_weight;

public class Runner {
    public static void main(String[] args) {
        int n = 5, source = 0, destination = 1, target = 5;
        int[][] edges = { { 4, 1, -1 }, { 2, 0, -1 }, { 0, 3, -1 }, { 4, 3, -1 } };
        new Solution().modifiedGraphEdges(n, edges, source, destination, target);
    }
}
