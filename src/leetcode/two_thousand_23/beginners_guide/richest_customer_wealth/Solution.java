package leetcode.two_thousand_23.beginners_guide.richest_customer_wealth;

public class Solution {
    // https://leetcode.com/problems/richest-customer-wealth/
    public int maximumWealth(int[][] accounts) {
        int richest_customer_wealth = 0;
        for(int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for(int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }
            richest_customer_wealth = richest_customer_wealth < wealth ? wealth : richest_customer_wealth;
        }
        return richest_customer_wealth;
    }
}
