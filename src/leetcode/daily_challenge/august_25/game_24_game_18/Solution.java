package leetcode.daily_challenge.august_25.game_24_game_18;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double) c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24.0) < EPS;

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums.get(i), b = nums.get(j);
                List<Double> candidates = generate(a, b);

                List<Double> next = new ArrayList<>(n - 1);
                for (int k = 0; k < n; k++) if (k != i && k != j) next.add(nums.get(k));

                for (double v : candidates) {
                    next.add(v);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
    private List<Double> generate(double a, double b) {
        List<Double> res = new ArrayList<>(6);
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPS) res.add(a / b);
        if (Math.abs(a) > EPS) res.add(b / a);
        return res;
    }
}