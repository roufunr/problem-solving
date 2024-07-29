package leetcode.two_thousand_24.weekly_contest.find_if_digit_game_can_be_won;

public class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        int singleSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] / 10 == 0) {
                singleSum += nums[i];
            }
            sum += nums[i];
        }
        if (singleSum > (sum - singleSum) || (sum - singleSum) > singleSum) {
            return true;
        }
        return false;
    }
}