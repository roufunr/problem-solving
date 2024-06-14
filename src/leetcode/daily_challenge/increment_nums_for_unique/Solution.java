package leetcode.daily_challenge.increment_nums_for_unique;

public class Solution {
    private void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] count = new int[max + 1];
        for (int n : nums) {
            count[n]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }

    public int minimumIncrementForUnique(int[] nums) {
        countSort(nums);
        int incCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                nums[i] += (nums[i - 1] - nums[i] + 1);
                incCount += (nums[i - 1] - nums[i] + 1);
            } else if (nums[i - 1] == nums[i]) {
                nums[i] += 1;
                incCount += 1;
            } else {
                // do nothing
            }
        }
        return incCount;
    }
}
