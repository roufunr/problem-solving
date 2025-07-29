package leetcode.daily_challenge.july_25.smallest_subarrays_with_maximum_bitwise_or_29;

import java.util.Arrays;

public class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] pos = new int[32];
        Arrays.fill(pos, -1);
        int[] result = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            int idx = 0;
            while(x > 0) {
                if(x % 2 == 1) {
                    pos[idx] = i;
                }
                x /= 2;
                idx++;
            }
            int maxPos = Integer.MIN_VALUE;
            for(int p : pos) {
                if(p == -1) {
                    continue;
                }
                maxPos = Math.max(maxPos, p);
            }
            result[i] = (maxPos == Integer.MIN_VALUE) ? 1 : maxPos - i + 1;
        }
        return result;
    }
}