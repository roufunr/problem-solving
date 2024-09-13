package leetcode.top150.product_of_array_except_self_12;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mult = 0;
        boolean zeroExist = false;
        for (int n : nums) {
            if (n != 0) {
                if (mult == 0) {
                    mult = n;
                } else {
                    mult *= n;
                }
            } else
                zeroExist = true;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            if (zeroExist) {
                if (nums[i] != 0)
                    ans[i] = 0;
                else
                    ans[i] = mult;
            } else {
                ans[i] = mult / nums[i];
            }

        }
        return ans;
    }
}