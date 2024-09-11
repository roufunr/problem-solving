package leetcode.daily_challenge.september_24.minimum_bit_flips_to_convert_number_11;

public class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 1 << i;
            if ((temp & xor) != 0) {
                count++;
            }
        }
        return count;
    }
}