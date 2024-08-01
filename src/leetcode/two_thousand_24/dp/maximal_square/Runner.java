package leetcode.two_thousand_24.dp.maximal_square;

public class Runner {
    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        new SolutionII().maximalSquare(matrix);
    }
}
