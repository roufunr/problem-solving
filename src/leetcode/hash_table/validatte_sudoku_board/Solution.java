package leetcode.hash_table.validatte_sudoku_board;

public class Solution {
    private boolean isRowSafe(char[][] board, int posX, int posY) {
        int size = board[0].length;
        for(int j = 0 ; j < size; j++) {
            if(posY == j) continue;
            if(board[posX][j] == board[posX][posY]) return false;
        }
        return true;
    }

    private boolean isCoumnSafe(char[][] board, int posX, int posY) {
        int size = board.length;
        for(int i = 0 ; i < size; i++) {
            if(posX == i) continue;
            if(board[i][posY] == board[posX][posY]) return false;
        }
        return true;
    }

    private boolean isSquareSafe(char[][] board, int posX, int posY) {
        int size = board.length;
        int squareSize =(int) Math.sqrt(size);
        int squareX = posX/3;
        int squareY = posY/3;

        for(int i = squareSize * squareX; i < (squareX + 1) * squareSize; i++) {
            for(int j = squareSize * squareY; j < (squareY + 1) * squareSize; j++) {
                if(i == posX && j == posY) continue;
                if(board[i][j] == board[posX][posY]) return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == '.') continue;
                if(isCoumnSafe(board, i, j) && isRowSafe(board, i, j) && isSquareSafe(board, i, j)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

//char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
//                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };
