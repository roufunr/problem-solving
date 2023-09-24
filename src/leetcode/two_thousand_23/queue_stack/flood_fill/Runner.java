package leetcode.two_thousand_23.queue_stack.flood_fill;

public class Runner {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        new Solution().floodFill(image, sr, sc, color);
    }
}
