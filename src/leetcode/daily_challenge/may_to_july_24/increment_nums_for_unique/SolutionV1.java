package leetcode.daily_challenge.may_to_july_24.increment_nums_for_unique;

public class SolutionV1 {
    public int minIncrementForUnique(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (max < n) {
                max = n;
            }
        }
        int[] count = new int[max + nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int incCount = 0;
        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] > 1) {
                incCount += count[i] - 1;
                count[i + 1] += count[i] - 1;
            }
        }
        return incCount;
    }
}