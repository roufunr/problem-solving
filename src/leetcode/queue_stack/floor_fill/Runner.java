package leetcode.queue_stack.floor_fill;

public class Runner {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;

        new Solution().floodFill(image, sr, sc, color);
    }
}
