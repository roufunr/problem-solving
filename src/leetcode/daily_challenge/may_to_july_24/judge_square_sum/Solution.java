package leetcode.daily_challenge.may_to_july_24.judge_square_sum;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            long t = i * i + j * j;
            if (t == c) {
                return true;
            } else if (t > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
