package leetcode.two_thousand_23.arrays_and_strings.minimum_size_subarray;

public class Runner {
    public static void main(String[] args) {
        int target = 213;
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        new Solution().minSubArrayLen(target, nums);
    }
}
