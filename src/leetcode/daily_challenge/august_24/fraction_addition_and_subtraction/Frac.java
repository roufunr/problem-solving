package leetcode.daily_challenge.august_24.fraction_addition_and_subtraction;

import java.util.*;

public class Frac {
    // ±numerator/denominator
    public boolean neg;
    public int n;
    public int d;

    public Frac(boolean neg, int n, int d) {
        this.neg = neg;
        this.n = n;
        this.d = d;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private int getLCM(List<Integer> nums) {
        int g = nums.get(0);
        long mul = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            g = getGCD(g, nums.get(i));
            mul = mul * nums.get(i);
        }
        return (int) (mul / g);
    }

    public void add(Frac f) {
        int lcm = getLCM(Arrays.asList(d, f.d));
        int new_n = ((lcm / d) * n) * (int) Math.pow(-1, neg ? 1 : 0)
                + ((lcm / f.d) * f.n) * (int) Math.pow(-1, f.neg ? 1 : 0);
        int gcd = getGCD(lcm, Math.abs(new_n));
        this.neg = new_n < 0;
        this.d = lcm / gcd;
        this.n = Math.abs(new_n) / gcd;
    }

    public String toString() {
        return (this.neg ? "-" : "") + this.n + "/" + this.d;
    }
}
