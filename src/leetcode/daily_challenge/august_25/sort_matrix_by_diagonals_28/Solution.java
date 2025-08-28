package leetcode.daily_challenge.august_25.sort_matrix_by_diagonals_28;

import java.util.*;

public class Solution {
    private void performSort(int x, int y, int[][] grid, boolean asc) {
        List<Integer> vals = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int nx = x;
        int ny = y;
        while(nx < m && ny < n) {
            vals.add(grid[nx][ny]);
            nx++;
            ny++;
        }
        nx = x;
        ny = y;
        if(!asc) {
            Collections.sort(vals, (a, b) -> (Integer.compare(b, a)));
        } else {
            Collections.sort(vals);
        }
        int k = 0;
        while(nx < m && ny < n) {
            grid[nx][ny] = vals.get(k);
            nx++;
            ny++;
            k++;
        }
    }
    public int[][] sortMatrix(int[][] grid) {
        for(int i = 0; i < grid[0].length; i++) {
            if(i > 0) performSort(0, i, grid, true);
            performSort(i, 0, grid, false);
        }
        return grid;
    }
}