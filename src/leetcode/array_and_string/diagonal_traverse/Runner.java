package leetcode.array_and_string.diagonal_traverse;

public class Runner {
    public static void main(String[] args) {
        int[][] mat = {
                {11,12,12,14,15},
                {21,22,23,24,25},
                {31,32,33,34,35}
        };

        new Solution().findDiagonalOrder(mat);
     }
}
