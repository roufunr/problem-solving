package leetcode.array_and_string.reverse_string;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
    public void reverseString(char[] s) {
        int len = s.length;
        int i = 0;
        int j = len - 1;
        while(i < (len/2)) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
