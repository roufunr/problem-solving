package leetcode.queue_stack.number_of_islands;

public class Runner {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','1'},
                {'1','1','0','1','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        new Solution().numIslands(grid);
    }
}


