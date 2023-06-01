package leetcode.array_and_string.longest_common_prefix;

public class Solution {
    int getSmallestLength(String[] strs) {
        int min = Integer.MAX_VALUE;
        for(String str : strs) {
            if(min > str.length()) {
                min = str.length();
            }
        }
        return min;
    }
    public String longestCommonPrefix(String[] strs) {
        //https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
        StringBuilder longCommonPrefixStr = new StringBuilder("");
        int minLength = getSmallestLength(strs);
        int i = 0;
        while (i < minLength) {
            char firstChar = strs[0].charAt(i);
            boolean isMatchedWithRest = true;
            for(int k = 1; k < strs.length; k++) {
                char c = strs[k].charAt(i);
                if(firstChar != c) {
                    isMatchedWithRest = false;
                    break;
                }
            }
            if(isMatchedWithRest) {
                longCommonPrefixStr.append(firstChar);
            } else {
                break;
            }
            i++;
        }
        String output = longCommonPrefixStr.toString();
        return output;
    }
}
