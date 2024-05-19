package leetcode.daily_challenge.find_maximum_sum_of_node_values;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {24,78,1,97,44};
        int k = 6;
        int[][] edges = {{0,2},{1,2},{4,2},{3,4}};
        new Solution().maximumValueSum(nums, 6, edges);

    }
}
