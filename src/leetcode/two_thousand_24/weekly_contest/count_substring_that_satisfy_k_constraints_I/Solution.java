package leetcode.two_thousand_24.weekly_contest.count_substring_that_satisfy_k_constraints_I;

public class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                int countOne = 0;
                // System.out.println(substring);
                for (int c : substring.toCharArray()) {
                    if (c == '1') {
                        countOne++;
                    }
                }
                if (countOne <= k || (j - i - countOne) <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}