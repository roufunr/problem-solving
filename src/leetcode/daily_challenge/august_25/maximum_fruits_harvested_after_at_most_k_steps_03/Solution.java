package leetcode.daily_challenge.august_25.maximum_fruits_harvested_after_at_most_k_steps_03;

public class Solution {
    private int stepsRequired(int[][] fruits, int startPos, int left, int right) {
        return fruits[right][0] - fruits[left][0] + Math.min(Math.abs(startPos - fruits[left][0]), Math.abs(startPos - fruits[right][0]));
    }
    
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        while(right < fruits.length) {
            sum += fruits[right][1];
            while(left <= right && stepsRequired(fruits, startPos, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            ans = Math.max(ans, sum);
            right++;
        }
        return ans;
    }
}
