package leetcode.two_thousand_24.dp.maximal_square;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        // bruteforce solution
        // runtime O((mn)^2)
        int maxSquareLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int currentSquareLen = 1;
                    boolean noZero = true;
                    while (i + currentSquareLen < matrix.length && j + currentSquareLen < matrix[0].length && noZero) {
                        for (int k = j; k <= j + currentSquareLen; k++) {
                            if (matrix[i + currentSquareLen][k] == '0') {
                                noZero = false;
                                break;
                            }
                        }
                        for (int k = i; k <= i + currentSquareLen; k++) {
                            if (matrix[k][j + currentSquareLen] == '0') {
                                noZero = false;
                                break;
                            }
                        }
                        if (noZero) {
                            currentSquareLen++;
                        }
                    }
                    maxSquareLen = Math.max(currentSquareLen, maxSquareLen);
                }
            }
        }
        return maxSquareLen * maxSquareLen;
    }
}