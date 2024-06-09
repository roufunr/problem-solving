package leetcode.two_thousand_24.recursionII.search_in_s_2D_matrix_II;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };

        // Define the target value to search for
        int target = 11;

        System.out.println(new SolutionV2().searchMatrix(matrix, target));
    }
}
