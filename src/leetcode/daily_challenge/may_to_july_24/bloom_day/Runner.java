package leetcode.daily_challenge.may_to_july_24.bloom_day;

public class Runner {
    public static void main(String[] args) {
        int[] bloomDay = { 7, 7, 7, 7, 12, 7, 7 };
        int m = 2;
        int k = 3;

        new Solution().minDays(bloomDay, m, k);
    }
}
