package leetcode.two_thousand_22.heap.the_K_weakest_rows_in_a_matrix;

public class Runner {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;

        new Solution().kWeakestRows(mat, k);
    }
}
