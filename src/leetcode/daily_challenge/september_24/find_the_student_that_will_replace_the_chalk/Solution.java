package leetcode.daily_challenge.september_24.find_the_student_that_will_replace_the_chalk;

public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long[] prefixSum = new long[chalk.length];
        long sum = 0;
        long longK = k;
        for (int i = 0; i < prefixSum.length; i++) {
            sum += chalk[i];
            prefixSum[i] = sum;
        }
        System.out.println(sum);
        longK = longK >= sum ? (longK % sum) : longK;
        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] > longK) {
                return i;
            }
        }
        return 0;
    }
}