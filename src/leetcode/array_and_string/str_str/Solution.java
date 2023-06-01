package leetcode.array_and_string.str_str;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
    public int strStr(String haystack, String needle) {
        char[] hArr = haystack.toCharArray();
        char[] nArr = needle.toCharArray();
        int idx = -1;
        if(hArr.length >= nArr.length) {
            for(int i = 0; i < hArr.length; i++) {
                boolean notMatched = false;
                for(int j = 0; j < nArr.length; j++) {
                    if((i + j) >= hArr.length || hArr[i + j] != nArr[j]) {
                        notMatched = true;
                        break;
                    }
                }
                if(!notMatched) {
                    idx = i;
                    break;
                }
            }
        }

        return idx;
    }
}
