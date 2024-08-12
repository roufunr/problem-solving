package lc_others.paths_in_matrix_whose_sum_is_divisible_by_k;

public class Runner {
    public static void main(String[] args) {
        int[][] grid = { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } };
        int k = 3;
        new SolutionII().numberOfPaths(grid, k);
    }
}
