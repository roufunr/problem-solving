package leetcode.daily_challenge.july_25.count_number_of_maximum_bitwise_or_subsets_28;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        int count = 0;
        for(int num : nums) {
            maxOR |= num;
        }
        int L = (int) Math.pow(2, nums.length);
        for(int i = 0; i < L; i++) {
            int currentOR = 0;
            int x = i;
            int j = 0;
            while(x > 0) {
                if(x % 2 == 1) {
                    currentOR |= nums[j];
                }
                j++;
                x = x/2;
            }
            if(currentOR == maxOR) {
                count++;
            }
        }
        return count;
    }
}