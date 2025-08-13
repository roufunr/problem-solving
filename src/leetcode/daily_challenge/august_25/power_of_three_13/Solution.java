package leetcode.daily_challenge.august_25.power_of_three_13;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }
        if(n == 1) {
            return true;
        }
        if(n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}