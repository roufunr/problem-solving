package leetcode.queue_stack.zero_one_matrix;

import java.util.*;

public class Solution {
    //https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/
    private int[][] mat;
    private int getVal(int[] pos) {
        return this.mat[pos[0]][pos[1]];
    }
    private void setVal(int[] pos, int val) {
        this.mat[pos[0]][pos[1]] = val;
    }
    public int[][] updateMatrix(int[][] mat) {
        this.mat = mat;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int[] pos = new int[] {i, j};
                if(getVal(pos) == 0) {
                    queue.add(pos);
                } else {
                    setVal(pos, Integer.MAX_VALUE);
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] currentPos = queue.remove();
            int hereDist = getVal(currentPos);
            int possibleNeighbourDist = hereDist + 1;
            int[] top = new int[] {currentPos[0] + 1, currentPos[1]};
            int[] bottom = new int[] {currentPos[0] - 1, currentPos[1]};
            int[] left = new int[] {currentPos[0] , currentPos[1] - 1};
            int[] right = new int[] {currentPos[0] , currentPos[1] + 1};

            if(top[0] < mat.length && getVal(top) > possibleNeighbourDist) {
                setVal(top, possibleNeighbourDist);
                queue.add(top);
            }

            if(bottom[0] >= 0 && getVal(bottom) > possibleNeighbourDist) {
                setVal(bottom, possibleNeighbourDist);
                queue.add(bottom);
            }

            if(left[1] >= 0 && getVal(left) > possibleNeighbourDist) {
                setVal(left, possibleNeighbourDist);
                queue.add(left);
            }

            if(right[1] < mat[0].length && getVal(right) > possibleNeighbourDist) {
                setVal(right, possibleNeighbourDist);
                queue.add(right);
            }
        }
        return this.mat;
    }
}
