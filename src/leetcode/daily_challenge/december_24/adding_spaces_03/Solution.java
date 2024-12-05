package leetcode.daily_challenge.december_24.adding_spaces_03;

public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb = new StringBuffer();
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(j < spaces.length && i == spaces[j]) {
                sb.append(" ");
                i--;
                j++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
