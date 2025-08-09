package leetcode.daily_challenge.august_25.power_of_two_09;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        int x =  n & (n - 1);
        return x == 0;
    }
}
