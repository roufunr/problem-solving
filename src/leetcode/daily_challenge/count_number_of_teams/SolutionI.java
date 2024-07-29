package leetcode.daily_challenge.count_number_of_teams;

public class SolutionI {
    private Integer[][] increasingRatingTeamCache;
    private Integer[][] decreasingRatingTeamCache;

    private int[] rating;

    private int countIncreasingTeams(int currentIdx, int currentTeamSize) {
        if (currentIdx == rating.length) {
            return 0;
        }
        if (currentTeamSize == 3) {
            return 1;
        }
        if (increasingRatingTeamCache[currentIdx][currentTeamSize] != null) {
            return increasingRatingTeamCache[currentIdx][currentTeamSize];
        }
        int teamCount = 0;
        for (int nextIdx = currentIdx + 1; nextIdx < rating.length; nextIdx++) {
            if (rating[currentIdx] < rating[nextIdx]) {
                teamCount += countIncreasingTeams(nextIdx, currentTeamSize + 1);
            }
        }
        increasingRatingTeamCache[currentIdx][currentTeamSize] = teamCount;
        return teamCount;
    }

    private int countDecreasingTeams(int currentIdx, int currentTeamSize) {
        if (currentIdx == rating.length) {
            return 0;
        }
        if (currentTeamSize == 3) {
            return 1;
        }
        if (decreasingRatingTeamCache[currentIdx][currentTeamSize] != null) {
            return decreasingRatingTeamCache[currentIdx][currentTeamSize];
        }
        int teamCount = 0;
        for (int nextIdx = currentIdx + 1; nextIdx < rating.length; nextIdx++) {
            if (rating[currentIdx] > rating[nextIdx]) {
                teamCount += countDecreasingTeams(nextIdx, currentTeamSize + 1);
            }
        }
        decreasingRatingTeamCache[currentIdx][currentTeamSize] = teamCount;
        return teamCount;
    }

    public int numTeams(int[] rating) {
        this.rating = rating;
        int totalTeams = 0;
        this.increasingRatingTeamCache = new Integer[rating.length][4];
        this.decreasingRatingTeamCache = new Integer[rating.length][4];
        for (int i = 0; i < rating.length; i++) {
            totalTeams += countIncreasingTeams(i, 1) + countDecreasingTeams(i, 1);
        }
        return totalTeams;
    }
}