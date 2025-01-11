package leetcode.daily_challenge.january_25.construct_k_palindrome_strings_11;

public class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
            }
        }
        if (oddCount > k) {
            return false;
        }
        return true;
    }
}