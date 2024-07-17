package leetcode.two_thousand_24.weekly_contest.min_cut;

import java.util.*;

public class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int h = horizontalCut.length - 1;
        int v = verticalCut.length - 1;
        int ans = 0;
        for (int i = 0; i < horizontalCut.length + verticalCut.length; i++) {
            if (v < 0) {
                ans += horizontalCut[h] * (n);
                h--;
            } else if (h < 0) {
                ans += verticalCut[v] * (m);
                v--;
            } else if (horizontalCut[h] > verticalCut[v]) {
                ans += horizontalCut[h] * (verticalCut.length - v);
                h--;
            } else if (horizontalCut[h] <= verticalCut[v]) {
                ans += verticalCut[v] * (horizontalCut.length - h);
                v--;
            }
        }
        return ans;
    }
}