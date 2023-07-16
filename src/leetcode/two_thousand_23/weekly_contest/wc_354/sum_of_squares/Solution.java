package leetcode.two_thousand_23.weekly_contest.wc_354.sum_of_squares;

public class Solution {
    // https://leetcode.com/contest/weekly-contest-354/problems/sum-of-squares-of-special-elements/
    public int sumOfSquares(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i = 1; i <= len; i++) {
            if(len % i == 0) {
                sum += nums[i-1] * nums[i-1];
            }
        }
        return sum;
    }
}
