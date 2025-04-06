package leetcode.daily_challenge.april_25.largest_divisible_subset_06;
import java.util.*;
public class Solution {
    private Set<String> set;
    private int[] nums;
    private List<Integer> ans;

    private void backtrack(int currentIdx, int prevItem, List<Integer> list) {
        if(currentIdx >= nums.length) {
            if(list.size() >= ans.size()) {
                ans = new ArrayList<>(list);
            }
            return;
        }
        if(this.set.contains(currentIdx + "_" + prevItem)) {
            return;
        }
        if(prevItem == 9) {
            System.err.println("hey");
        }
        this.set.add(currentIdx + "_" + prevItem);
        if(this.nums[currentIdx] % prevItem == 0) {
            list.add(nums[currentIdx]);
            backtrack(currentIdx + 1, nums[currentIdx], list);
            list.remove(list.size() - 1);
        }
        if(prevItem == 9) {
            System.err.println("hey");
        }
        backtrack(currentIdx, prevItem, list);
        backtrack(currentIdx + 1, prevItem, list);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        this.set = new HashSet<>();
        this.ans = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(0, 1, new ArrayList<>());
        return this.ans;
    }
}