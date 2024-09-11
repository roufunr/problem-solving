package leetcode.top150.best_time_to_buy_and_sell_stock_07;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minInvest = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - minInvest > maxProfit) {
                maxProfit = prices[i] - minInvest;
            }
            minInvest = Math.min(minInvest, prices[i]);
        }
        return maxProfit;
    }
}