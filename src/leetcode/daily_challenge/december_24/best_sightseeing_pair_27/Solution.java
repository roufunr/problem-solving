package leetcode.daily_challenge.december_24.best_sightseeing_pair_27;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] maxLeftScore = new int[values.length];
        maxLeftScore[0] = values[0];
        int maxScore = 0;
        for(int i = 1; i < values.length; i++) {
            int currentRightScore = values[i] - i;
            maxScore = Math.max(maxScore, currentRightScore + maxLeftScore[i - 1]);
            maxLeftScore[i] = Math.max(maxLeftScore[i-1], values[i] + i);
        }
        return maxScore;
    }
}