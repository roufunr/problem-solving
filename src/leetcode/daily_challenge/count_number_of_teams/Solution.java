package leetcode.daily_challenge.count_number_of_teams;

public class Solution {
    // brute force
    // O(N^3)
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        ans++;
                    } else if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}