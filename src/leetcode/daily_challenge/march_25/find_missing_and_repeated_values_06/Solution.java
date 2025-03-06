package leetcode.daily_challenge.march_25.find_missing_and_repeated_values_06;

public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] count = new int[grid.length * grid.length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                count[grid[i][j] - 1]++;
            }
        }
        int[] ans = {-1, -1};
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 2) {
                ans[0] = i + 1;
            }
            if(count[i] == 0) {
                ans[1] = i + 1;
            }
        }
        return ans;
    }
}