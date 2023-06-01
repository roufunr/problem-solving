package leetcode.queue_stack.target_sum;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int target = 25;
        new Solution().findTargetSumWays(nums, target);
    }
}
