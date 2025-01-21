package leetcode.daily_challenge.january_25.grid_game_21;

public class Solution {
    private long[][] calculateCumulative(int[][] grid) {
        long[][] cum = new long[grid.length][grid[0].length];
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < grid[0].length; i++) {
            sum1 += grid[0][i];
            sum2 += grid[1][i];
            cum[0][i] = sum1;
            cum[1][i] = sum2;
        }
        return cum;
    }
    public long gridGame(int[][] grid) {
        long[][] cum = calculateCumulative(grid);
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < cum[0].length; i++) {
            long topRight = cum[0][cum[0].length - 1] - cum[0][i];
            long bottomLeft = i > 0 ? cum[1][i - 1] : 0;
            ans = Math.min(Math.max(topRight, bottomLeft), ans);
        }
        return ans;
    }
}