package leetcode.two_thousand_24.weekly_contest.alternating_groupII;

public class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] newColor = new int[colors.length + k - 1];
        for(int i = 0; i < colors.length; i++) {
            newColor[i] = colors[i];
        }
        for(int i = colors.length; i < newColor.length; i++) {
            newColor[i] = colors[i - colors.length];
        }
        int count = 1;
        int result = 0;
        for(int i = 1; i < newColor.length; i++) {
            if(newColor[i] != newColor[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if(count >= k) {
                result++;
            }
        }
        return result;
    }
}
