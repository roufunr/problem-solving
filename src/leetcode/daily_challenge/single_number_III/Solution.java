package leetcode.daily_challenge.single_number_III;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for (int n : set) {
            ans[i] = n;
            i++;
        }

        return ans;
    }
}