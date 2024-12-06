package leetcode.daily_challenge.december_24.maximum_number_of_integers_to_choose_from_a_range_i_06;
import java.util.*;
public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int ban : banned) {
            set.add(ban);
        }
        int count = 0;
        int sum = 0;
        for(int i = 1; i <= n && (sum + i) <= maxSum; i++) {
            if(set.contains(i)) {
                continue;
            } else {
                sum += i;
                count++;
            }
        }
        return count;
    }
}