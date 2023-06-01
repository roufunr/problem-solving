package leetcode.hash_table.two_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    //https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1179/
    private Map<Integer, Integer> map;
    List<Integer> list;
    private int currentLen;
    public TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<>();
        currentLen = 0;
    }

    public void add(int number) {
        list.add(number);
        map.put(number, currentLen);
        currentLen++;
    }

    public boolean find(int value) {
        int k = 0;
        for(int n : list) {
            int rest = value - n;
            if(map.containsKey(rest)) {
                int idx = map.get(rest);
                if(idx == k) {
                    continue;
                } else {
                    return true;
                }
            }
            k++;
        }
        return false;
    }
}
