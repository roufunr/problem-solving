package lc_others.non_decreasing_subsequences;

import java.util.*;

public class Solution {
    private Set<List<Integer>> ans;
    private List<Integer> subSeq;
    private int[] nums;

    private void backTrack(int idx) {
        if (idx == nums.length) {
            if (subSeq.size() >= 2) {
                ans.add(new ArrayList<>(subSeq));
            }
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (subSeq.size() == 0 || subSeq.get(subSeq.size() - 1) <= nums[i]) {
                subSeq.add(nums[i]);
                backTrack(i + 1);
                subSeq.remove(subSeq.size() - 1);
            }
            backTrack(i + 1);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        ans = new HashSet<>();
        subSeq = new ArrayList<>();
        backTrack(0);
        return new ArrayList<>(ans);
    }
}