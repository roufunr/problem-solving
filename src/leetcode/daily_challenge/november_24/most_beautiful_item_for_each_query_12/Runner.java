package leetcode.daily_challenge.november_24.most_beautiful_item_for_each_query_12;

public class Runner {
    public static void main(String[] args) {
        int[][] items = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } };
        new Solution().maximumBeauty(items, new int[] { 1, 2, 3, 4, 5, 6 });
    }
}