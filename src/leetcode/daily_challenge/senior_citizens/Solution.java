package leetcode.daily_challenge.senior_citizens;

public class Solution {
    public int countSeniors(String[] details) {
        int sixtyCount = 0;
        for (String detail : details) {
            Integer age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                sixtyCount++;
            }
        }
        return sixtyCount;
    }
}