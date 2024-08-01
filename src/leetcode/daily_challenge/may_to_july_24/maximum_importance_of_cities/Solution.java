package leetcode.daily_challenge.may_to_july_24.maximum_importance_of_cities;

import java.util.Arrays;

public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] cnt = new int[n];
        for (int[] road : roads) {
            for (int city : road) {
                cnt[city]++;
            }
        }
        Arrays.sort(cnt);
        long ans = 0;
        long i = 1;
        for (int c : cnt) {
            ans += (i * c);
            i++;
        }
        return ans;
    }
}
