package lc_others.longest_substring_with_at_least_k_repeating_characters;

public class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
                int lowest = Integer.MAX_VALUE;
                for (int l = 0; l < 26; l++) {
                    if (count[l] != 0) {
                        lowest = Math.min(lowest, count[l]);
                    }
                }
                if(lowest >= k) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}