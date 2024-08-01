package leetcode.daily_challenge.may_to_july_24.filling_bookcase_shelves;

public class Solution {
    private int shelfWidth;
    private int[][] books;
    private Integer[] cache;

    private int dp(int idx) {
        if (idx == books.length) {
            return 0;
        }
        if (cache[idx] != null) {
            return cache[idx];
        }
        int remainingWidth = this.shelfWidth;
        int height = 0;
        int totalHeight = Integer.MAX_VALUE;
        for (int i = idx; i < books.length; i++) {
            if (remainingWidth < books[i][0]) {
                break;
            }
            remainingWidth -= books[i][0];
            height = Math.max(height, books[i][1]);
            totalHeight = Math.min(totalHeight, height + dp(i + 1));
        }
        cache[idx] = totalHeight;
        return totalHeight;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.shelfWidth = shelfWidth;
        this.books = books;
        cache = new Integer[books.length];
        return dp(0);
    }
}