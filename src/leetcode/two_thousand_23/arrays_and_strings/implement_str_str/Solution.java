package leetcode.two_thousand_23.arrays_and_strings.implement_str_str;

public class Solution {
    // https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
    public int strStr(String haystack, String needle) {
        char[] h_arr = haystack.toCharArray();
        char [] n_arr = needle.toCharArray();
        for(int i = 0; i < h_arr.length; i++) {
            boolean isMatched = true;
            for(int j = 0; j < n_arr.length; j++) {
                if(i + j >= h_arr.length) {
                    return -1;
                }
                if(h_arr[i + j] != n_arr[j]) {
                    isMatched = false;
                    break;
                }
            }
            if(isMatched) {
                return i;
            }
        }
        return -1;
    }
}
