package leetcode.top150.best_time_to_buy_and_sell_stock_II_08;

public class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}