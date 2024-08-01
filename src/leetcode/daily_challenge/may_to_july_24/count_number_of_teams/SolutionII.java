package leetcode.daily_challenge.may_to_july_24.count_number_of_teams;

public class SolutionII {
    // tabulation method solution is better than top down approach

    public int numTeams(int[] rating) {
        int totalTeams = 0;
        int[][] inc = new int[rating.length][4];
        int[][] dec = new int[rating.length][4];
        for (int i = 0; i < rating.length; i++) {
            inc[i][1] = 1;
            dec[i][1] = 1;
        }
        for (int c = 2; c < 4; c++) {
            for (int startIdx = 0; startIdx < rating.length; startIdx++) {
                for (int currentIdx = startIdx + 1; currentIdx < rating.length; currentIdx++) {
                    if (rating[startIdx] > rating[currentIdx]) {
                        dec[currentIdx][c] += dec[startIdx][c - 1];
                    }
                    if (rating[startIdx] < rating[currentIdx]) {
                        inc[currentIdx][c] += inc[startIdx][c - 1];
                    }
                }
            }
        }

        for (int i = 0; i < rating.length; i++) {
            totalTeams += dec[i][3] + inc[i][3];
        }
        return totalTeams;
    }
}