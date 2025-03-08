package leetcode.daily_challenge.march_25.minimum_recolors_to_get_k_consecutive_black_blocks_08;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int sum = 0;
        int maxSum = sum;
        int windowLen = 0;
        for(int i = 0; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'B') {
                sum++;
            }
            if(windowLen >= k && blocks.charAt(i - k) == 'B') {
                sum--;
                windowLen--;
            }
            maxSum = Math.max(maxSum, sum);
            windowLen++;
        }
        return k - maxSum;
    }
}