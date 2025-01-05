package leetcode.daily_challenge.january_25.shifting_letters_ii_05;

public class Runner {
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
        new Solution().shiftingLetters(s, shifts);
    }
}
