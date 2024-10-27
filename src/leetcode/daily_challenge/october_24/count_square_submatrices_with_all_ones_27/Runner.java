package leetcode.daily_challenge.october_24.count_square_submatrices_with_all_ones_27;

public class Runner {
    public static void main(String[] args) {
        int[][] matrix = 
        {
          {0,1,1,1},
          {1,1,1,1},
          {0,1,1,1}
        };
        System.out.println(new Solution().countSquares(matrix));
    }
}
