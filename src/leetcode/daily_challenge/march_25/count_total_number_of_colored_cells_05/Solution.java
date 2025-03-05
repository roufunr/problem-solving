package leetcode.daily_challenge.march_25.count_total_number_of_colored_cells_05;

public class Solution {
    public long coloredCells(int n) {
        long x = (long) n;
        return 2 * x * (x - 1) + 1;
    }
}