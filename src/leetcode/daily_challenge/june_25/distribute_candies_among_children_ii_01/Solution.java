package leetcode.daily_challenge.june_25.distribute_candies_among_children_ii_01;

public class Solution {
    public long distributeCandies(int n, int limit) {
        long count = 0;
        for(int i = 0; i <= Math.min(limit, n); i++) {
            int remaining = n - i;
            if(remaining > 2 * limit) {
                continue;
            } else {
                count += Math.min(remaining, 2 * limit - remaining) + 1;
            }
        }
        return count;
    }
}
