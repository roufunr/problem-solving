package leetcode.daily_challenge.november_24.maximum_xor_for_each_query_08;

public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int XOR = 0;
        for (int n : nums) {
            XOR ^= n;
        }
        int maxNum = (int) (Math.pow(2, maximumBit) - 1);
        int[] ans = new int[nums.length];
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[j++] = XOR ^ maxNum;
            XOR ^= nums[i];
        }
        return ans;
    }
}