package leetcode.daily_challenge.may_to_july_24.grumpy_bookstore;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxUtil = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                maxUtil += customers[i];
            }
        }
        int idx = 0;
        int newUtil = maxUtil;
        for (int i = 1; i < customers.length - minutes + 1; i++) {
            if (grumpy[i - 1] == 1) {
                newUtil -= customers[i - 1];
            }
            if (grumpy[i + minutes - 1] == 1) {
                newUtil += customers[i + minutes - 1];
            }
            // System.out.println(newUtil);
            maxUtil = maxUtil < newUtil ? newUtil : maxUtil;
            idx = maxUtil < newUtil ? i : idx;
        }

        int ans = 0;
        for (int i = 0; i < customers.length; i++) {
            ans += grumpy[i] == 0 ? customers[i] : 0;
        }
        ans += maxUtil;
        return ans;
    }
}