package leetcode.daily_challenge.july_25.find_the_maximum_length_of_valid_subsequence_ii_17;

public class Solution {
    // the idea is the even position modulo should be equal and also the odd position modulo should be equal
    // we're storing the maximum length of valid subsequence in a 2D array
    // where dp[i][j] is the maximum length of valid subsequence with i as the even position modulo and j as the odd position modulo
    // we iterate through the array and update the dp array accordingly
    // time complexity: O(n * k)
    // here i and j means the modulo of the even and odd indexed elements respectively
    // space complexity: O(k^2)
    //
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int result = 2;
        for(int n : nums) {
            int cur = n % k;
            for(int prev = 0; prev < k; prev++) {
                dp[prev][cur] = dp[cur][prev] + 1;
                result = Math.max(dp[prev][cur], result);
            }
        }
        return result;
    }
}
