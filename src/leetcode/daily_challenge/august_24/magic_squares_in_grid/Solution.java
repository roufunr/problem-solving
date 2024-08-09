package leetcode.daily_challenge.august_24.magic_squares_in_grid;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private boolean isMagicSquare(int[][] grid, int x, int y) {
        int rowSum = 0;
        Set<Integer> present = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[x + i][y + j] > 9 || grid[x + i][y + j] < 1) {
                    return false;
                }
                present.add(grid[x + i][y + j]);
            }
        }
        if (present.size() != 9) {
            return false;
        }
        for (int j = 0; j < 3; j++) {
            rowSum += grid[x][y + j];
        }
        // check rows
        for (int i = 1; i < 3; i++) {
            int tempSum = 0;
            for (int j = 0; j < 3; j++) {
                tempSum += grid[x + i][y + j];
            }
            if (tempSum != rowSum) {
                return false;
            }
        }
        // check cols
        for (int j = 0; j < 3; j++) {
            int tempSum = 0;
            for (int i = 0; i < 3; i++) {
                tempSum += grid[x + i][y + j];
            }
            if (tempSum != rowSum) {
                return false;
            }
        }

        // check positive diagonal
        int tempSum = 0;
        for (int i = 0; i < 3; i++) {
            tempSum += grid[x + i][y + i];
        }
        if (tempSum != rowSum) {
            return false;
        }

        // check negative diagonals
        tempSum = 0;
        for (int i = 0; i < 3; i++) {
            // System.out.println((x + i) + " " + (y + 3 - i - 1));
            tempSum += grid[x + i][y + 3 - i - 1];
        }
        if (tempSum != rowSum) {
            return false;
        }

        // otherwise
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int magicSquareCount = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    magicSquareCount++;
                }
            }
        }
        return magicSquareCount;
    }
}