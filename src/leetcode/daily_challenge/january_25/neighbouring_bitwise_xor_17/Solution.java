package leetcode.daily_challenge.january_25.neighbouring_bitwise_xor_17;

public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int n : derived) {
            xor ^= n;
        }
        for (int n : derived) {
            if ((xor ^ n) != n) {
                return false;
            }
        }
        return true;
    }
}
