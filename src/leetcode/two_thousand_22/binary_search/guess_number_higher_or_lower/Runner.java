package leetcode.two_thousand_22.binary_search.guess_number_higher_or_lower;

public class Runner {
    public static void main(String[] args) {
        for(int i = 0; i <= Integer.MAX_VALUE; i++) {
            int N = i;
            Solution solution = new Solution(N);
            solution.guessNumber(N);
            System.out.println("---");
        }
    }
}
