package leetcode.top150.product_of_array_except_self_12;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int mult = 0;
        for(int n : nums) {
            if(n == 0) {
               zeroCount++; 
            } else {
                if(mult == 0) {
                    mult += n;
                } else {
                    mult *= n;
                }
            }
        }
        int[] ans = new int[nums.length];
        if(zeroCount >= 2) {
            return ans;
        }
        for(int i = 0; i < nums.length; i++) {
            if(zeroCount == 1) {
                if(nums[i] == 0) {
                    ans[i] = mult;
                }
            } else {
                ans[i] = mult / nums[i];
            }
        }
        return ans;
    }
}