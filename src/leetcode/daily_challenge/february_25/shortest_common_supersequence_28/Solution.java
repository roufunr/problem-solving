class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        int[][] dp = new int[str1Length + 1][str2Length + 1];

        
        for (int row = 0; row <= str1Length; row++) {
            dp[row][0] = row;
        }
        
        for (int col = 0; col <= str2Length; col++) {
            dp[0][col] = col;
        }

        
        for (int row = 1; row <= str1Length; row++) {
            for (int col = 1; col <= str2Length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    
                    dp[row][col] =
                        Math.min(dp[row - 1][col], dp[row][col - 1]) + 1;
                }
            }
        }

        StringBuilder supersequence = new StringBuilder();
        int row = str1Length, col = str2Length;

        while (row > 0 && col > 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                
                supersequence.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] < dp[row][col - 1]) {
                
                supersequence.append(str1.charAt(row - 1));
                row--;
            } else {
                
                supersequence.append(str2.charAt(col - 1));
                col--;
            }
        }

        
        while (row > 0) {
            supersequence.append(str1.charAt(row - 1));
            row--;
        }
        
        while (col > 0) {
            supersequence.append(str2.charAt(col - 1));
            col--;
        }
        return supersequence.reverse().toString();
    }
}