package leetcode.daily_challenge.sort_the_people;

import java.util.*;

public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], i);
        }
        int i = 0;
        String[] ans = new String[names.length];
        while (map.size() > 0) {
            ans[i++] = names[map.get(map.lastKey())];
            map.remove(map.lastKey());
        }
        return ans;
    }
}