package leetcode.two_thousand_24.recursion.pascal_s_triangle_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {
    private Map<String, Integer> map;
    public Solution() {
        map = new HashMap<>();
    }
    private int getPascalNumber(int i, int j) {
        if(j == 0 || j == i) {
            return 1;
        }
        String p1 = i + "_" + j;
        String p2 = i + "_" + (i-j);
        if(map.containsKey(p1)) {
            return map.get(p1);
        } else if(map.containsKey(p2)) {
            return map.get(p2);
        }
        int val = getPascalNumber(i-1, j-1) + getPascalNumber(i-1, j);
        map.put(i-j < j ? p2 : p1, val);
        return val;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            ans.add(getPascalNumber(rowIndex, i));
        }
        // System.err.println(map.size());
        return ans;
    }
}
