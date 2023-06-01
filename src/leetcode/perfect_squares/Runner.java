package leetcode.perfect_squares;

public class Runner {
    public static void main(String[] args) {
        for(int i = 1; i <= 10000; i++) {
            System.out.println(i + "-> " + new Solution().numSquares(i));
        }
    }
}
