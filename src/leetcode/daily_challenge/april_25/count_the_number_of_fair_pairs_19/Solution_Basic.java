package leetcode.daily_challenge.april_25.count_the_number_of_fair_pairs_19;

public class Solution_Basic {
    long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] <= upper && nums[i] + nums[j]>=lower) {
                    count++;
                }
            }
        }
        return count;
    }
}
