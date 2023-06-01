package leetcode.hash_table.contains_duplicates;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(new Solution().containsDuplicate(nums));

        int[] nums1 = {1,2,3,4,5,1};
        System.out.println(new Solution().containsDuplicate(nums1));
    }
}
