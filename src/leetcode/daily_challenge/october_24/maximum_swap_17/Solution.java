package leetcode.daily_challenge.october_24.maximum_swap;

public class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        int max = num;
        for(int i = 0; i < sb.length() - 1; i++) {
            char ithChar = sb.charAt(i);
            for(int j = i + 1; j < sb.length(); j++) {
                char jthChar = sb.charAt(j);
                StringBuilder newSb = new StringBuilder(sb.toString());
                newSb.setCharAt(j, ithChar);
                newSb.setCharAt(i, jthChar);
                max = Math.max(max, Integer.parseInt(newSb.toString()));
            }
        }
        return max;
    }
}