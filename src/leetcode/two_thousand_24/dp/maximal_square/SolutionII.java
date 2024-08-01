package leetcode.two_thousand_24.dp.maximal_square;

public class SolutionII {
    // dp solution
    // memory wise better than solution I
    public int maximalSquare(char[][] matrix) {
        int[] dp = new int[matrix[0].length];
        int maxSqLn = 0;
        for(int i = 0; i < matrix[0].length; i++) {
            dp[i] = matrix[0][i] - '0';
            maxSqLn = Math.max(dp[i], maxSqLn);
        }
        for(int i = 1; i < matrix.length; i++) {
            int prev = matrix[i][0] - '0';
            maxSqLn = Math.max(prev, maxSqLn);
            for(int j = 1; j < matrix[0].length; j++) {
                int newPrev = 0;
                if(matrix[i][j] == '1') {
                    newPrev = Math.min(prev, Math.min(dp[j-1], dp[j])) + 1;
                } 
                dp[j-1] = prev;
                prev = newPrev;
                maxSqLn = Math.max(prev, maxSqLn);
            }
            dp[dp.length - 1] = prev;
        }
        return maxSqLn * maxSqLn;
    }
}