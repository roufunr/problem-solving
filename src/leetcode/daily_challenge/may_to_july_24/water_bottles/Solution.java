package leetcode.daily_challenge.may_to_july_24.water_bottles;

public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles / numExchange > 0) {
            int temp = numBottles / numExchange;
            ans += temp;
            numBottles = (numBottles % numExchange) + temp;
        }
        return ans;
    }
}
