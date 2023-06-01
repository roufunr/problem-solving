package leetcode.array_and_string.minimum_size_subarray_sum;

public class Solution {
    public int getSum(int[] sum, int[] nums, int i, int j) {
        int subArraySum = sum[j] - sum[i] + nums[i - 1];
        return subArraySum;
    }
    public int binarySearch(int[] sums,int[] nums, int target, int i) {
        int startIdx = i;
        int endIdx = sums.length - 1;
        int midIdx = (startIdx + endIdx) / 2;
        int possibleIdx = -1;
        do {
            int midIdxSum = getSum(sums, nums, i, midIdx);
            if(midIdxSum == target) {
                return midIdx;
            } else if(target < midIdxSum) {
                endIdx = midIdx - 1;
                possibleIdx = midIdx;
            } else if(target > midIdxSum) {
                startIdx = midIdx + 1;
            }
            midIdx =(startIdx + endIdx) / 2;
        } while(startIdx <= endIdx);
        return possibleIdx;
    }

    public int[] getSumArray(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return sums;
    }

    public int minSubArrayLen(int target, int[] nums) {
        //https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
        int[] sums = getSumArray(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int possibleIdx = binarySearch(sums, nums,target, i + 1);

            if(possibleIdx != -1) {
                System.out.println(i + "  " + (possibleIdx - 1) + " --> SUM: " + getSum(sums, nums, i + 1, possibleIdx));
                ans = Math.min(ans, possibleIdx - i);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
