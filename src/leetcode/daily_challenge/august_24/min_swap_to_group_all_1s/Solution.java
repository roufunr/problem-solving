package leetcode.daily_challenge.august_24.min_swap_to_group_all_1s;

import java.util.PriorityQueue;

public class Solution {
    public int minSwaps(int[] nums) {
        int countOne = 0;
        for (int n : nums) {
            if (n == 1) {
                countOne++;
            }
        }
        int one = 0;
        for (int i = 0; i < countOne; i++) {
            if (nums[i] == 1) {
                one++;
            }
        }
        int maxOne = Integer.MIN_VALUE;
        maxOne = Math.max(one, maxOne);
        for (int L = 1; L < nums.length; L++) {
            int R = (L + countOne - 1) % nums.length;
            if (nums[L - 1] == 1) {
                one--;
            }
            if (nums[R] == 1) {
                one++;
            }
            maxOne = Math.max(one, maxOne);
        }
        return countOne - maxOne;
    }
}