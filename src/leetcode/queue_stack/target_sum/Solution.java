package leetcode.queue_stack.target_sum;

public class Solution {
    //https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/
    private int target;
    private int totalWays = 0;

    private void calculateSum(int[] nums, int cumulativeSum, int position) {
        int cumulativeSumPlus = cumulativeSum + nums[position];
        int cumulativeSumNeg = cumulativeSum - nums[position];
        if(position == nums.length - 1) {
            totalWays = target == cumulativeSumPlus ? totalWays + 1 : totalWays;
            totalWays = target == cumulativeSumNeg ? totalWays + 1 : totalWays;
            return;
        }
        calculateSum(nums, cumulativeSumPlus, position + 1);
        calculateSum(nums, cumulativeSumNeg, position + 1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        calculateSum(nums, 0, 0);
        return totalWays;
    }
}
