package leetcode.daily_challenge.november_24.shortest_subarray_with_or_at_least_k_ii_10;

public class Solution {
    private int[] bits;
    private int getOR() {
        int or = 0;
        for(int i = 0; i < 32; i++) {
            if(bits[i] > 0) or += Math.pow(2, i);
        }
        return or;
    }
    private void addNum(int n) {
        int i = 0;
        while(n > 0) {
            bits[i++] += (n % 2);
            n /= 2;
        }
    }

    private void removeNum(int n) {
        int i = 0;
        while(n > 0) {
            bits[i++] -= (n % 2);
            n /= 2;
        }
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        bits = new int[32];
        int or = getOR();
        while(end < nums.length) {
            addNum(nums[end]);
            or = getOR();
            while(or >= k && start <= end) {
                ans = Math.min(ans, end - start + 1);
                removeNum(nums[start]);
                or = getOR();
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}