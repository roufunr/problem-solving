package leetcode.daily_challenge.august_24.two_keys_keyboard;

public class SolutionII {
    private boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int minSteps(int n) {
        int ans = 0;
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                if (isPrime(i)) {
                    ans += i;
                }
                n = n / i;
            } else {
                i++;
            }
        }
        return ans;
    }
}
