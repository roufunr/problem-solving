package leetcode.two_thousand_23.arrays_and_strings.longest_common_prefix;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
    public String longestCommonPrefix(String[] strs) {
        StringBuffer lcp = new StringBuffer();
        lcp.append("");
        for(int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            boolean presentInAll = true;
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i) {
                    presentInAll = false;
                    break;
                }
                if(strs[0].charAt(i) != strs[j].charAt(i)) {
                    presentInAll = false;
                    break;
                }
            }
            if (presentInAll == false) {
                break;
            } else {
                lcp.append(ch);
            }
        }
        return lcp.toString();
    }
}
