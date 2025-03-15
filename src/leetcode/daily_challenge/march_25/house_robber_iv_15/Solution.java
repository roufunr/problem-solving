package leetcode.daily_challenge.march_25.house_robber_iv_15;

public class Solution {
    private int getCountLessOrEqualMid(int[] nums, int m) {
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        while(i < nums.length) {
            if(nums[i] <= m) {
                count1++;
                i += 2;
            } else {
                i++;
            }
        }
        i = 1;
        while(i < nums.length) {
            if(nums[i] <= m) {
                count2++;
                i += 2;
            } else {
                i++;
            }
        }
        return Math.max(count1, count2);
    }
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            max = Math.max(n, max);
        }
        return max;
    } 
    public int minCapability(int[] nums, int k) {
        int left = 1;
        int right = getMax(nums);
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int count = getCountLessOrEqualMid(nums, mid);
            if(count >= k) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}