package leetcode.daily_challenge.july_25.find_the_maximum_length_of_valid_subsequence_i_16;

public class Solution {
    // total 4 patterns:
    // all items in subarray are even
    // all items in subarray are odd
    // first item is even, second item is odd, third item is even, ...
    // first item is odd, second item is even, third item is odd, ...
    // we can use a greedy approach to find the maximum length of valid subsequence
    // by iterating through the array and checking each pattern
    // time complexity: O(n)
    // space complexity: O(1)
    //
    public int maximumLength(int[] nums) {
        int[][] patterns = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int maxCount = 0;
        for(int[] pattern : patterns) {
            int count = 0;
            for(int n : nums) {
                if(n % 2 == pattern[count % 2]) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}