package leetcode.heap.top_k_frequent;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//https://leetcode.com/explore/learn/card/heap/646/practices/4015/
class Pair implements Comparable<Pair> {
    private int key;
    private int value;

    public int getKey() {
        return key;
    }

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair o) {
        return o.value - this.value;
    }
}
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] ans  = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = heap.poll().getKey();
        }
        return ans;
    }
}
