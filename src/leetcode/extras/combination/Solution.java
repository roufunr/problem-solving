package leetcode.extras.combination;

import java.util.*;

public class Solution { // Solved with backtracking
    private int n;
    private int k;
    private List<List<Integer>> ans;

    private void helper(Set<Integer> c, int m) {
        if (c.size() == k) {
            List<Integer> eachCombination = new ArrayList<>();
            for(int e : c) {
                eachCombination.add(e);
            }
            ans.add(eachCombination);
            return;
        }

        for (int i = m; i <= n; i++) {
            if (!c.contains(i)) {
                c.add(i);
                helper(c, i + 1);
                c.remove(i);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        helper(set, 1);
        return ans;
    }
}