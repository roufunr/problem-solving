package leetcode.binary_search.x_pow_n;

import java.util.HashMap;

public class Solution {
    //https://leetcode.com/explore/learn/card/binary-search/137/conclusion/982/
    HashMap<Integer, Double> memory;
    private double pow(double x_to_sth, int times) {
        if(memory.containsKey(times)) {
            return memory.get(times);
        }

        int leftHalf = times / 2;
        int rightHalf = times - leftHalf;
        if(leftHalf == 0) {
            double mult = 1 * x_to_sth;
            memory.put(times, mult);
            return mult;
        } else {
            double mult = pow(x_to_sth, leftHalf) * pow(x_to_sth, rightHalf);
            memory.put(times, mult);
            return mult;
        }
    }
    public double myPow(double x, int n) {
        memory = new HashMap<>();
        memory.put(0, 1d);
        double ans = pow(x, Math.abs(n));
        return n < 0 ? 1 / ans : ans;
    }
}
