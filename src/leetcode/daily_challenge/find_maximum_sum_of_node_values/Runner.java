package leetcode.daily_challenge.find_maximum_sum_of_node_values;

public class Runner {
    public static void main(String[] args) {
        int[] nums = { 67, 13, 79, 13, 75, 11, 0, 41, 94 };
        int k = 7;
        int[][] edges = { { 0, 1 }, { 3, 7 }, { 4, 7 }, { 6, 5 }, { 6, 0 }, { 0, 2 }, { 7, 2 }, { 7, 8 } };
        new Solution().maximumValueSum(nums, k, edges);

    }
}
