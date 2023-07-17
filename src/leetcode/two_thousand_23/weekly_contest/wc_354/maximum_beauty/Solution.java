package leetcode.two_thousand_23.weekly_contest.wc_354.maximum_beauty;

import java.util.Arrays;

public class Solution {
    // https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int startIdx = 0;
        int endIdx = 0;
        int max = 0;
        while(startIdx < nums.length && endIdx < nums.length) {
            int diff = nums[endIdx] - nums[startIdx];
            if(diff <= (2 * k)) {
                max = endIdx - startIdx + 1 > max ? endIdx - startIdx + 1 : max;
                endIdx++;
            } else {
                startIdx++;
            }
            if(startIdx > endIdx) {
                endIdx = startIdx;
            }
        }
        return max;
    }

}
