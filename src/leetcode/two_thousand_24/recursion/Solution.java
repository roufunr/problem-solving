package leetcode.two_thousand_24.recursion;

public class Solution {
    private void helper(char[] str, int i, int j) {
        if(i >= j) {
            return;
        }
        char c = str[j];
        str[j] = str[i];
        str[i] = c;
        helper(str, i + 1, j - 1);
    }
    
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
}
