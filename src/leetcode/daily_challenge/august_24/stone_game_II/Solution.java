package leetcode.daily_challenge.august_24. ;

public class Solution {
    private int[][][] cache;

    private int dp(int[] piles, int M, int idx, int turn) {
        if (piles.length <= idx) {
            return 0;
        }
        if (cache[idx][M - 1][turn] != 0) {
            return cache[idx][M - 1][turn];
        }
        if (turn == 0) {
            int maxScore = Integer.MIN_VALUE;
            int totalScore = 0;
            for (int i = 1; i <= (2 * M) && (i + idx <= piles.length); i++) {
                totalScore += piles[idx + i - 1];
                maxScore = Math.max(maxScore, totalScore + dp(piles, Math.max(M, i), idx + i, 1));
            }
            cache[idx][M - 1][turn] = maxScore;
            return maxScore;
        } else {
            int minScore = Integer.MAX_VALUE;
            for (int i = 1; i <= (2 * M) && (i + idx <= piles.length); i++) {
                minScore = Math.min(minScore, dp(piles, Math.max(M, i), idx + i, 0));
            }
            cache[idx][M - 1][turn] = minScore;
            return minScore;
        }
    }

    public int stoneGameII(int[] piles) {
        cache = new int[piles.length][piles.length][2];
        return dp(piles, 1, 0, 0);
    }
}