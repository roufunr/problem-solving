package leetcode.two_thousand_23.hash_table.top_k_frequent_elements;

import java.util.*;

class Pair {
    public int first;
    public int second;
}
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        Comparator<Pair> comparator = (a, b) -> b.second - a.second;
        PriorityQueue<Pair> pQ = new PriorityQueue<>(comparator);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair pair = new Pair();
            pair.first = entry.getKey();
            pair.second = entry.getValue();
            pQ.add(pair);
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pQ.poll().first;
        }
        return ans;
    }
}
