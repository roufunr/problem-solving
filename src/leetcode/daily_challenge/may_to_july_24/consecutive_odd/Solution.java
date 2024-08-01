package leetcode.daily_challenge.may_to_july_24.consecutive_odd;

public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            int cnt = 0;
            for (int j = i - 2; j <= i; j++) {
                if (arr[j] % 2 == 1) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == 3) {
                return true;
            }
        }
        return false;
    }
}