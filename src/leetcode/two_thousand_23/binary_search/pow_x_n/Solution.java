package leetcode.two_thousand_23.binary_search.pow_x_n;

public class Solution {
    public double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double mult = pow(x, n/2);
        if(n % 2 == 0) {
            return mult * mult;
        } else {
            return mult * mult * x;
        }
    }
    public double myPow(double x, int n) {
        double tempResult = pow(x, n < 0 ? n * (-1) : n);
        return n < 0 ? 1/tempResult : tempResult;
    }
}
