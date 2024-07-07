package leetcode.two_thousand_24.weekly_contest.alternating_group;

public class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        if (colors.length <= 1) {
            return 0;
        }
        for (int i = 0; i < colors.length; i++) {
            if (i == 0) {
                if (colors[colors.length - 1] != colors[0] && colors[0] != colors[1]) {
                    count++;
                }
            } else if (i == colors.length - 1 && colors.length > 2) {
                if (colors[i] != colors[i - 1] && colors[i] != colors[0]) {
                    count++;
                }
            } else {
                if (colors[i] != colors[i - 1] && colors[i] != colors[i + 1]) {
                    count++;
                }
            }
        }
        return count;
    }
}
