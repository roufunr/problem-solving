package leetcode.hash_table.contains_duplicate_II;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(new Solution().containsNearbyDuplicate(nums, k));
    }
}
