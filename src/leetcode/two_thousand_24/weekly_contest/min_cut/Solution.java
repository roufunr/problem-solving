package leetcode.two_thousand_24.weekly_contest.min_cut;

import java.util.*;

class Pair {
    public int cut;
    public int idx;

    public Pair(int cut, int idx) {
        this.cut = cut;
        this.idx = idx;
    }
}

public class Solution {
    private List<Pair> horizontalCut;
    private List<Pair> verticalCut;
    private Map<String, Integer> dp = new HashMap<>();

    private int fn(int m, int n, int hIdx, int vIdx) {
        if (m == 1 && n == 1) {
            return 0;
        }
        String key = m + "_" + n + "_" + hIdx + "_" + vIdx;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int min = Integer.MAX_VALUE;
        if (hIdx >= 0 && hIdx < horizontalCut.size()) {
            int idx = horizontalCut.get(hIdx).idx;
            int h = horizontalCut.get(hIdx).cut + fn(idx + 1, n, -1, vIdx) + fn(m - (idx + 1), n, hIdx + 1, vIdx);
            min = Math.min(min, h);
        }
        if (vIdx >= 0 && vIdx < verticalCut.size()) {
            int idx = verticalCut.get(vIdx).idx;
            int v = verticalCut.get(vIdx).cut + fn(m, idx + 1, hIdx, -1) + fn(m, n - (idx + 1), hIdx, vIdx + 1);
            min = Math.min(min, v);
        }
        dp.put(key, min);
        return dp.get(key);
    }

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        List<Pair> hCuts = new ArrayList<>();
        List<Pair> vCuts = new ArrayList<>();
        for (int i = 0; i < horizontalCut.length; i++) {
            hCuts.add(new Pair(horizontalCut[i], i));
        }
        for (int i = 0; i < verticalCut.length; i++) {
            vCuts.add(new Pair(verticalCut[i], i));
        }
        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p2.cut, p1.cut);
            }
        };
        Collections.sort(hCuts, comp);
        Collections.sort(vCuts, comp);
        this.horizontalCut = hCuts;
        this.verticalCut = vCuts;
        int result = fn(m, n, 0, 0);
        return result;
    }
}