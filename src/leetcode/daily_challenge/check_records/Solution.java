package leetcode.daily_challenge.check_records;

public class Solution {
    private static final int MOD = 1000000000 + 7;

    public int checkRecord(int n) {
        int[][] prevDP = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                prevDP[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            int[][] newDP = new int[2][3];
            for (int a = 0; a < 2; a++) {
                for (int l = 0; l < 3; l++) {
                    newDP[a][l] += prevDP[a][2];
                    if (a > 0) {
                        newDP[a][l] += prevDP[a - 1][2];
                        newDP[a][l] %= MOD;
                    }
                    if (l > 0) {
                        newDP[a][l] += prevDP[a][l - 1];
                        newDP[a][l] %= MOD;
                    }
                }
            }
            prevDP = newDP;
        }

        return prevDP[1][2];
    }
}
