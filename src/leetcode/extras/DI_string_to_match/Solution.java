package leetcode.extras.DI_string_to_match;

public class Solution {
    public int[] diStringMatch(String s) {
        int min = 0;
        int max = s.length();
        int[] ans = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                ans[i] = max;
                max--;
            } else {
                ans[i] = min;
                min++;
            }
        }
        ans[ans.length - 1] = min;
        return ans;
    }
}