package leetcode.top150.remove_duplicates_from_sorted_array_ii_04;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int currentNum = nums[0];
        int deleteCount = 0;
        for(int i = 1; i < nums.length; i++) {
            if(currentNum != nums[i]) {
                count = 1;
                currentNum = nums[i];
                continue;
            }

            if(count == 2) {
                nums[i] = Integer.MIN_VALUE;
                deleteCount++;
            } else {
                count++;
            }
            
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == Integer.MIN_VALUE) {
                for(int j = i + 1; j < nums.length; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums.length - deleteCount;
    }
}