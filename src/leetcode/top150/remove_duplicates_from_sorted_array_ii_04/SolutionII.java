package leetcode.top150.remove_duplicates_from_sorted_array_ii_04;

public class SolutionII {
    // O(N) Solution
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        int count = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            if(count <= 2) {
                nums[idx] = nums[j];
                idx++;
            }
        }
        return idx;
    }
}
