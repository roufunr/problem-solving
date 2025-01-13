package leetcode.daily_challenge.january_25.minimum_length_of_string_after_operations_13;

public class Solution {
    public int minimumLength(String s) {
        if (s.length() < 3) {
            return s.length();
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int ans = 0;
        for (int n : freq) {
            if (n > 2) {
                ans += (n % 2) == 0 ? 2 : 1;
            } else {
                ans += n;
            }
        }
        return ans;
    }
}