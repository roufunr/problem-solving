package leetcode.daily_challenge.july_25.count_hills_and_valleys_in_an_array_27;

public class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            int j = i - 1;
            for(; j >= 0; j--) {
                if(nums[j] != nums[i]) {
                    break;
                }
            }
            if(j < 0) {
                continue;
            }

            int k = i + 1;
            for(; k < nums.length; k++) {
                if(nums[k] != nums[i]) {
                    break;
                }
            }
            if(k == nums.length) {
                continue;
            }
            if(nums[i] > nums[j] && nums[i] > nums[k]) {
                count++;
            } else if(nums[i] < nums[j] && nums[i] < nums[k]) {
                count++;
            }
            i = (k - 1);
        }
        return count;
    }
}
