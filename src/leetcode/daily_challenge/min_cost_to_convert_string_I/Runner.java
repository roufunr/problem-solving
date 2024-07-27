package leetcode.daily_challenge.min_cost_to_convert_string_I;

public class Runner {
    public static void main(String[] args) {
        String source = "abcd";
        String target = "acbe";
        char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' };
        char[] changed = { 'b', 'c', 'b', 'e', 'b', 'e' };
        int[] cost = { 2, 5, 5, 1, 2, 20 };
        new Solution().minimumCost(source, target, original, changed, cost);
    }
}
