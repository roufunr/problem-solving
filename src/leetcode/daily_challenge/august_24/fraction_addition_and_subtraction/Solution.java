package leetcode.daily_challenge.august_24.fraction_addition_and_subtraction;

import java.util.*;

class Fraction {
    // ±numerator/denominator
    public boolean neg;
    public int n;
    public int d;

    public Fraction(boolean neg, int n, int d) {
        this.neg = neg;
        this.n = n;
        this.d = d;
    }
}

class Solution {
    private List<String> split(String expression) {
        List<String> parts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-') {
                if (sb.length() > 0)
                    parts.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(c);
        }
        if (sb.length() > 0)
            parts.add(sb.toString());
        return parts;
    }

    private List<Fraction> getFrac(List<String> parts) {
        List<Fraction> fracs = new ArrayList<>();
        for (String part : parts) {
            String str = new String(part);
            boolean neg = false;
            if (part.charAt(0) == '-') {
                neg = true;
                str = str.replace("-", "");
            } else if (part.charAt(0) == '+') {
                str = str.replace("+", "");
            }
            Fraction frac = new Fraction(neg, Integer.parseInt(str.split("/")[0]), Integer.parseInt(str.split("/")[1]));
            fracs.add(frac);
        }
        return fracs;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int getLCM(List<Integer> nums) {
        int g = nums.get(0);
        long mul = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            g = gcd(g, nums.get(i));
            mul = mul * nums.get(i);
        }
        return (int) (mul / g);
    }

    public String fractionAddition(String expression) {
        List<Fraction> fracs = getFrac(split(expression));
        if (fracs.size() == 1) {
            int g = gcd(fracs.get(0).d, fracs.get(0).n);
            String ans = ((fracs.get(0).neg) ? "-" : "") + Math.abs(fracs.get(0).n / g) + "/"
                    + Math.abs(fracs.get(0).d / g);
            return ans;
        }
        List<Integer> denomIntegers = new ArrayList<>();
        for (Fraction f : fracs) {
            denomIntegers.add(f.d);
        }
        int d = getLCM(denomIntegers);
        int n = 0;
        for (Fraction f : fracs) {
            n += Math.pow(-1, f.neg ? 1 : 0) * ((d / f.d) * f.n);
        }
        int g = gcd(Math.abs(d), Math.abs(n));
        String ans = ((n < 0 || d < 0) ? "-" : "") + Math.abs(n / g) + "/" + Math.abs(d / g);
        return ans;
    }
}