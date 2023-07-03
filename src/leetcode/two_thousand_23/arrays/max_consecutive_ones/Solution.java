package leetcode.two_thousand_23.arrays.max_consecutive_ones;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOneCount = 0;
        int currentCount = 0;
        for(int n : nums) {
            currentCount = n == 0 ? 0 : currentCount + 1;
            if(currentCount > maxOneCount) {
                maxOneCount = currentCount;
            }
        }
        return maxOneCount;
    }
}
