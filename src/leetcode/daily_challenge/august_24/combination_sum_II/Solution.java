package leetcode.daily_challenge.august_24.combination_sum_II;

import java.util.*;

public class Solution {
    private Set<List<Integer>> allcombinations;
    private int target;
    private int[] candidates;

    private void backTrack(int idx, int sum, List<Integer> combination) {
        if (sum == target) {
            allcombinations.add(new ArrayList<>(combination));
        }
        if (idx == candidates.length) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > idx && candidates[i] == candidates[i - 1])
                continue;
            combination.add(candidates[i]);
            backTrack(i + 1, sum + candidates[i], combination);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        this.candidates = candidates;
        List<Integer> combination = new ArrayList<>();
        allcombinations = new HashSet<>();
        backTrack(0, 0, combination);
        return new ArrayList<>(allcombinations);
    }
}