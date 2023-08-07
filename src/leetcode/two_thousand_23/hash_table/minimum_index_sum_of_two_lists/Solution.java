package leetcode.two_thousand_23.hash_table.minimum_index_sum_of_two_lists;
import java.util.*;
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int newSum = i + map.get(list2[i]);
                if(newSum < minSum) {
                    minSum = newSum;
                }
            }
        }
        List<String> minSumStrings = new ArrayList<>();
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int newSum = i + map.get(list2[i]);
                if(newSum == minSum) {
                    minSumStrings.add(list2[i]);
                }
            }
        }

        String[] ans = new String[minSumStrings.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = minSumStrings.get(i);
        }
        return ans;
    }
}
