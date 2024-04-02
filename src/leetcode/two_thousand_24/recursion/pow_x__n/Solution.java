package leetcode.two_thousand_24.recursion.pow_x__n;


public class Solution {
    public double calculate(double x, int n) {
        if(n == 0) {
            return 1;
        } else if(n == 1) {
            return x;
        }  else {
            double half = calculate(x, n/2);
            double result = half * half * (n%2 == 0? 1 : x);
            return result;
        }
    }

    public double myPow(double x, int n) {
        boolean n_is_negative = n < 0;
        double ans = calculate(x, Math.abs(n));
        ans = n_is_negative ? 1/ans : ans;
        return ans;
    }
}
