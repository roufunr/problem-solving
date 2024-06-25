package leetcode.daily_challenge.longest_continuous_subarray;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        new Solution().longestSubarray(nums, limit);
    }
}
