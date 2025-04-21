package leetcode.daily_challenge.april_25.count_the_hidden_sequences_21;

public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long currentPosition = 0;
        long left = 0;
        long right = 0;
        for(int diff: differences) {
            currentPosition += (long) diff;
            left = Math.min(currentPosition, left);
            right = Math.max(currentPosition, right);
        }
        long span = Math.abs(right - left) + 1;
        long space = upper- lower + 1;
        return space - span + 1 <= 0 ? 0 : (int)(space - span + 1);
    }
}
