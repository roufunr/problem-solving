package leetcode.daily_challenge.may_to_july_24.grumpy_bookstore;

public class Runner {
    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;

        new Solution().maxSatisfied(customers, grumpy, minutes);
    }
}
