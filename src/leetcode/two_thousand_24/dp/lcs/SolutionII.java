package leetcode.two_thousand_24.dp.lcs;

public class SolutionII { // bottom up approach is much better
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                int currentMax = Math.max(dp[i-1][j], dp[i][j-1]);
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    currentMax = Math.max(currentMax, 1 + dp[i-1][j-1]);
                }
                dp[i][j] = currentMax;
            }
        }
        return dp[dp.length - 1][dp[0].length -1];
    }
}
