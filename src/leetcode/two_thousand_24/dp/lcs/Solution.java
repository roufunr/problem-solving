package leetcode.two_thousand_24.dp.lcs;

import java.util.*;

public class Solution {
    private String text1;
    private String text2;
    Map<String, Integer> cache = new HashMap<>();

    private int dp(int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        String key = i + "_" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int ans = Integer.MIN_VALUE;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = Math.max(ans, 1 + dp(i + 1, j + 1));
        }
        ans = Math.max(ans, Math.max(dp(i, j + 1), dp(i + 1, j)));
        cache.put(key, ans);
        return ans;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int ans = dp(0, 0);
        return ans;
    }
}