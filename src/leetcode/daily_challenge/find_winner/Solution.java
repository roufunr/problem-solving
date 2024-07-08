package leetcode.daily_challenge.find_winner;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            values.add(i + 1);
        }
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            start += k;
            start = start % values.size() == 0 ? values.size() - 1 : start % values.size() - 1;
            // System.out.println(values.get(start));
            values.remove(start);
        }
        return values.get(0);
    }
}
