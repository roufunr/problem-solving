package leetcode.daily_challenge.remove_max_number_of_edges;

public class Runner {
    public static void main(String[] args) {
        int[][] edges = {{1,1,2},{2,1,2},{3,1,2}};
        int n = 2;
        new Solution().maxNumEdgesToRemove(n, edges);
    }
}
