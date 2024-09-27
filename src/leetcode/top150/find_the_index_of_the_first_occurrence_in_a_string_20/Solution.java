package leetcode.top150.find_the_index_of_the_first_occurrence_in_a_string_20;

public class Solution {
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