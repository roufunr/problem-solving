package leetcode.daily_challenge.august_25.find_the_minimum_area_to_cover_all_ones_i_22;

public class Solution {
    public int minimumArea(int[][] grid) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if(i < minX) {
                        minX = i;
                    }
                    if(j < minY) {
                        minY = j;
                    }
                    if(i > maxX) {
                        maxX = i;
                    }
                    if(j > maxY) {
                        maxY = j;
                    }
                }
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);
    }
}
