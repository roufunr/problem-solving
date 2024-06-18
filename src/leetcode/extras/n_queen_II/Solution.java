package leetcode.extras.n_queen_II;

import java.util.*;

public class Solution {
    private int n;
    private int count;

    private void helper(int r, Set<Integer> colSet, Set<Integer> pdSet, Set<Integer> ndSet) {
        if (r == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int col = i;
            int pd = r + col;
            int nd = r - col;
            if (colSet.contains(col) || pdSet.contains(pd) || ndSet.contains(nd)) {
                continue;
            } else {
                pdSet.add(pd);
                ndSet.add(nd);
                colSet.add(col);
                this.helper(r + 1, colSet, pdSet, ndSet);
                pdSet.remove(pd);
                ndSet.remove(nd);
                colSet.remove(col);
            }
        }

    }

    public int totalNQueens(int n) {
        this.n = n;
        this.count = 0;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pdSet = new HashSet<>();
        Set<Integer> ndSet = new HashSet<>();
        this.helper(0, cols, pdSet, ndSet);
        return count;
    }
}