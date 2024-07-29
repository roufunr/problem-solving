package leetcode.two_thousand_24.weekly_contest.find_the_non_special_number_count;

public class Solution {
    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int nonSpecialCount(int l, int r) {
        int ans = r - l + 1;
        if (l <= 4 && r >= 4) {
            ans--;
        }
        for (int i = 3; i * i <= r; i += 2) {
            if (isPrime(i)) {
                if (i * i >= l && i * i <= r) {
                    ans--;
                }
            }
        }
        return ans;
    }
}