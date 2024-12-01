package lc_others.the_number_of_full_rounds_you_have_played;

public class Solution {
    private int convertMin(String time) {
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
    public int numberOfRounds(String loginTime, String logoutTime) {
        int start = convertMin(loginTime);
        int end = convertMin(logoutTime);

        int roundedStart = ((start + 14) / 15) * 15;
        int roundedEnd = (int)(Math.floor(end / 15) * 15);
        if(start < end) {
            return Math.max(0, (roundedEnd - roundedStart)/15);
        }

        return (24 * 60 - roundedStart + roundedEnd) / 15;
    }
}
