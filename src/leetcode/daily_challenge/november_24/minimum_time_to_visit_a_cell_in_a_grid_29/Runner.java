package leetcode.daily_challenge.november_24.minimum_time_to_visit_a_cell_in_a_grid_29;

public class Runner {
    public static void main(String[] args) {
        // int[][] grid = {
        //     {0, 2, 4},
        //     {3, 2, 1},
        //     {1, 0, 4}
        // };
        // int[][] grid = {
        //     {0, 1, 3, 2},
        //     {5, 1, 2, 5},
        //     {4, 3, 8, 6}
        // };
        int[][] grid = {
            {0, 1, 99},
            {3, 99, 99},
            {4, 5, 6}
        };
        
        new Solution().minimumTime(grid);
    }
}
