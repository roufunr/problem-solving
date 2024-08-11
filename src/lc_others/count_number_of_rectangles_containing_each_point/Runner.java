package lc_others.count_number_of_rectangles_containing_each_point;

public class Runner {
    public static void main(String[] args) {
        int[][] rectangles = {{1,2},{2,3},{2,5}};
        int[][] points = {{2,1},{1,4}};
        new SolutionII().countRectangles(rectangles, points);
    }
}
