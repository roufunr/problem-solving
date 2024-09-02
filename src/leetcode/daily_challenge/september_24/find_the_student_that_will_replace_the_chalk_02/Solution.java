package leetcode.daily_challenge.september_24.find_the_student_that_will_replace_the_chalk_02;

public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        long longK = k;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        longK = longK >= sum ? (longK % sum) : longK;
        sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > longK) {
                return i;
            }
        }
        return 0;
    }
}