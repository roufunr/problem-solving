package leetcode.daily_challenge.september_24.kth_smallest_in_lexicographical_order_22;

public class Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            if (step <= k) {
                curr++;
                k -= step;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}