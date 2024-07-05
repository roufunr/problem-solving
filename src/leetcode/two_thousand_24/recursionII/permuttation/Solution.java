package leetcode.two_thousand_24.recursionII.permuttation;

import java.util.*;

public class Solution {
    private int[] nums;
    private List<List<Integer>> ans;

    private void helper(List<Integer> perm) {
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!perm.contains(nums[i])) {
                perm.add(nums[i]);
                helper(perm);
                perm.remove(perm.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        helper(perm);
        return ans;
    }
}