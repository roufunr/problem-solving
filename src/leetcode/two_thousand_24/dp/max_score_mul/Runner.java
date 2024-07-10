package leetcode.two_thousand_24.dp.max_score_mul;

public class Runner {
    public static void main(String[] args) {
        int[] nums = { -5, -3, -3, -2, 7, 1 };
        int[] multipliers = { -10, -5, 3, 4, 6 };
        new Solution().maximumScore(nums, multipliers);
    }
}
