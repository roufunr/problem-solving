package leetcode.array_and_string.pascal_triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        //https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1171/
        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            rows.add(1);
        }

        for(int i = rowIndex - 1; i > 0; i--) {
            for(int j = 1; j <= i; j++) {
                int sum = rows.get(j) + rows.get(j - 1);
                rows.set(j, sum);
            }
        }
        return rows;
    }
}
