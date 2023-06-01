package leetcode.hash_table.top_k_frequent_element;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class Entry implements Comparable<Entry> {
    private int key;
    private int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Entry o) {
        int val = this.getValue() > o.getValue() ? -1 : 1;
        return val;
    }
}
public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            if(map.containsKey(n)) {
                int val = map.get(n);
                val++;
                map.put(n, val);
            } else {
                map.put(n, 1);
            }
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Entry en = new Entry(entry.getKey(), entry.getValue());
            pq.add(en);
        }


        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
