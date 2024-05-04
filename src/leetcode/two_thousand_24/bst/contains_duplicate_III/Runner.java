package leetcode.two_thousand_24.bst.contains_duplicate_III;

public class Runner {
    public static void main(String[] args) {
        int[] nums = { 1,5,9,1,5,9 };
        int indexDiff = 2;
        int valueDiff = 3;
        new Solution().containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
    }
}

