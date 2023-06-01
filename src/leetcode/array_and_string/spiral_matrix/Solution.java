package leetcode.array_and_string.spiral_matrix;

import java.util.ArrayList;
import java.util.List;
enum Direction {
    LEFT, RIGTH, UP, DOWN
}
class State {
    public int x;
    public int y;
    public Direction direction;
    public State() {
        x = 0;
        y = 0;
        direction = Direction.RIGTH;
    }

    public void moveLeft() {
        y--;
    }

    public void moveRight() {
        y++;
    }

    public void moveUp() {
        x--;
    }

    public void moveDown() {
        x++;
    }

    public void changeDirection() {
        if(direction == Direction.UP) {
            direction = Direction.RIGTH;
        } else if(direction == Direction.DOWN) {
            direction = Direction.LEFT;
        } else if(direction == Direction.RIGTH) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.UP;
        }
    }
    public boolean hasNextMove(boolean[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        if(direction == Direction.RIGTH) {
            if(y < column - 1 && !mat[x][y+1]) {
                moveRight();
            } else if(x < row - 1 && !mat[x+1][y]) {
                moveDown();
                changeDirection();
            } else {
                return false;
            }
            return true;
        } else if(direction == Direction.DOWN) {
            if(x < row - 1 && !mat[x+1][y]) {
                moveDown();
            } else if(y > 0 && !mat[x][y-1]) {
                moveLeft();
                changeDirection();
            } else {
                return false;
            }
            return true;
        } else if(direction == Direction.LEFT) {
            if(y > 0 && !mat[x][y-1]) {
                moveLeft();
            } else if(x > 0 && !mat[x-1][y]) {
                moveUp();
                changeDirection();
            } else {
                return false;
            }
            return true;
        } else if(direction == Direction.UP) {
            if(x > 0 && !mat[x-1][y]) {
                moveUp();
            } else if(y < column - 1 && !mat[x][y + 1]) {
                moveRight();
                changeDirection();
            } else {
                return false;
            }
            return true;
        }
        return false;
    }
}

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] flagMat = new boolean[row][column];
        List<Integer> arr = new ArrayList<>();
        State currentState = new State();
        boolean nextMove;
        do {
            flagMat[currentState.x][currentState.y] = true;
            arr.add(matrix[currentState.x][currentState.y]);
            nextMove = currentState.hasNextMove(flagMat);
        } while (nextMove);
        return arr;
    }
}
