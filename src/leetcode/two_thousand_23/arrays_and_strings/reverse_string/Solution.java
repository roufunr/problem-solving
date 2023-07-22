package leetcode.two_thousand_23.arrays_and_strings.reverse_string;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
    public void reverseString(char[] s) {
        for(int i = 0; i < (s.length / 2); i++) {
            char tempChar = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tempChar;
        }
    }
}
