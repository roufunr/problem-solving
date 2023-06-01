package leetcode.array_and_string.minimum_size_subarray_sum;

public class SolutionII {
    public int minSubArrayLen(int target, int[] nums) {
        ////https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int initIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - initIdx + 1);
                sum -= nums[initIdx];
                initIdx++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
