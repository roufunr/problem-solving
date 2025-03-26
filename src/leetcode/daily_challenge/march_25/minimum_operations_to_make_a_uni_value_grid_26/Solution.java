package leetcode.daily_challenge.march_25.minimum_operations_to_make_a_uni_value_grid_26;

import java.util.Arrays;

public class Solution {
    private boolean hasSolution(int[][] grid, int x) {
        int reminder = grid[0][0] % x;
        for(int[] row: grid) {
            for(int val: row) {
                if(reminder != (val % x)) {
                    return false;
                }
            }
        }
        return true;
    }
    private int[] convert1DArray(int[][] grid) {
        int[] arr = new int[grid.length * grid[0].length];
        int idx = 0;
        for(int[] row : grid) {
            for(int val : row) {
                arr[idx++] = val;
            }
        }
        return arr;
    }
    public int minOperations(int[][] grid, int x) {
        if(!hasSolution(grid, x)) {
            return -1;
        }
        int[] arr = convert1DArray(grid);
        Arrays.sort(arr);
        int[] prefixSum = new int[arr.length];
        int total = 0;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            prefixSum[i] = total;
        }

        int minOperation = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int prefixSize = i;
            int postfixSize = arr.length - i - 1;
            int totalPrefix = 0;
            int totalPostfix = 0;
            if(i > 0) {
                totalPrefix = prefixSum[i] - arr[i];
            }
            if(i < arr.length - 1) {
                totalPostfix = total - prefixSum[i];
            }
            int totalOperation = (prefixSize * arr[i] - totalPrefix)/x;
            totalOperation += (totalPostfix - postfixSize * arr[i])/x;
            minOperation = Math.min(minOperation, totalOperation);
        }
        return minOperation;
    }
}