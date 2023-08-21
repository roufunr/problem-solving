package leetcode.two_thousand_23.hash_table.top_k_frequent_elements;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        new Solution().topKFrequent(nums, k);
    }
}
