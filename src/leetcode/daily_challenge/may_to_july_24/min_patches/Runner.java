package leetcode.daily_challenge.may_to_july_24.min_patches;

public class Runner {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 31, 33 };
        int n = Integer.MAX_VALUE;
        new Solution().minPatches(nums, n);
    }
}
