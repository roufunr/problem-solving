package leetcode.daily_challenge.august_25.power_of_four_14;

public class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) {
            return false;
        } else if(n == 1) {
            return true;
        } else if(n % 4 >= 1 && n % 4 <= 3) {
            return false;
        } else {
            return isPowerOfFour(n / 4);
        }
    }
}