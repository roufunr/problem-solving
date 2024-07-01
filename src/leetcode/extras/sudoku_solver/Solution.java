package leetcode.extras.sudoku_solver;

public class Solution {

    private boolean solve(char[][] board, int i, int j) {
        if (i == 8 && j == 9) {
            return true;
        }
        if (j == 9) {
            i++;
            j = 0;
        }
        if (board[i][j] != '.') {
            j += 1;
            solve(board, i, j);
        }
        for (int x = 1; x < 10; x++) {
            if (safePlacement(board, (char) (x + '0'), i, j)) {
                board[i][j] = (char) (x + '0');
                j+=1;
                if (solve(board, i, j)) {
                    return true;
                } else {
                    board[i][j] = '.';
                }
            }

        }
        return false;
    }

    private boolean safePlacement(char[][] board, char p, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == p) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == p) {
                return false;
            }
        }

        int start_i = row / 3;
        int start_j = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[start_i + i][start_j + j] == p) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}