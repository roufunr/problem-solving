package leetcode.current.beginners_guide.richest_customer_wealth;

public class Runner {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1}
        };
        new Solution().maximumWealth(accounts);
    }
}
