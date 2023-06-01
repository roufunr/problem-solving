package leetcode.array_and_string.reverse_words;

public class Solution {
    public void reverse(String[] strs) {
        int fromIdx = 0;
        int toIdx = strs.length - 1;
        int mid = (toIdx + fromIdx) / 2;
        for(int i = 0; i <= mid; i++) {
            String temp = strs[i];
            strs[i] = strs[toIdx - i];
            strs[toIdx - i] = temp;
        }
    }

    public String concatWords(String[] strs) {
        StringBuilder strb = new StringBuilder("");
        for(String str : strs) {
            if(str.isEmpty()) {
                continue;
            }
            strb.append(str).append(" ");
        }
        String finalString = strb.toString().trim();
        return finalString;
    }
    public String reverseWords(String s) {
        //https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/
        
        s = s.trim();
        String[] strArr = s.split(" ");
        s = concatWords(strArr);
        strArr = s.split(" ");
        reverse(strArr);
        String finalStr = concatWords(strArr);
        return finalStr;
    }
}
