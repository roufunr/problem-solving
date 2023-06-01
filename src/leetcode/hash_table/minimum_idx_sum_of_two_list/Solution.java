package leetcode.hash_table.minimum_idx_sum_of_two_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        int k = 1;
        for(String str : list1) {
            map.put(str, -k);
            k++;
        }

        k = 1;
        for(String str : list2) {
            if(map.containsKey(str)) {
                int idx = map.get(str) * (-1);
                idx = idx + k;
                map.put(str, idx);
            }
            k++;
        }

        int min = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() < min && entry.getValue() >= 0) {
                min = entry.getValue();
            }
        }

        if(min < 0) {
            return new String[0];
        }

        List<String> ansString = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == min) {
               ansString.add(entry.getKey());
            }
        }

        String[] ans = ansString.toArray(new String[ansString.size()]);
        return  ans;
    }
}
