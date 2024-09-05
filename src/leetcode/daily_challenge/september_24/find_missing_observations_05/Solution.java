package leetcode.daily_challenge.september_24.find_missing_observations_05;

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (n + m);
        for(int roll : rolls) {
            total -= roll;
        }
        if(total < (1 * n) || total > (6 * n)) {
            return new int[]{};
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = 1;
            total--;
        }
        int j = 0;
        while(total > 0) {
            for(int k = 5; k >= 1; k--) {
                if(k <= total) {
                    ans[j++] += k;
                    total-=k;
                    break;
                }
            }
        }
        return ans;
    }
}