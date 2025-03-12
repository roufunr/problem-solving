package leetcode.daily_challenge.march_25.maximum_count_of_position_or_negative_integers_12;

public class Solution {
    public int maximumCount(int[] nums) {
        int posCount = 0;
        int negCount = 0;
        for(int n : nums) {
            if(n < 0) {
                negCount++;
            } else if(n > 0) {
                posCount++;
            }
        }
        return Math.max(posCount, negCount);
    }
}
