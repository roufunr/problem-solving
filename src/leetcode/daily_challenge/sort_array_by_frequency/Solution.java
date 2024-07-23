package leetcode.daily_challenge.sort_array_by_frequency;

import java.util.*;

class Pair {
    public int n;
    public int count;

    public Pair(int n, int count) {
        this.n = n;
        this.count = count;
    }
}

public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Pair> list = new ArrayList<>();
        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.count == p2.count) {
                    return Integer.compare(p2.n, p1.n);
                } else {
                    return Integer.compare(p1.count, p2.count);
                }
            }
        };
        for (Integer key : map.keySet()) {
            list.add(new Pair(key, map.get(key)));
        }
        Collections.sort(list, comp);
        int i = 0;
        for (Pair p : list) {
            for (int j = 0; j < p.count; j++) {
                nums[i++] = p.n;
            }
        }
        return nums;
    }
}