package leetcode.binary_search.find_the_duplicate_number_1__to_n_plus_1;

public class Solution {
	public int findDuplicate(int[] nums) {
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			int idx = Math.abs(nums[i]) - 1;                                     ;
			if(nums[idx] < 0) {
				return idx + 1;
			} else {
				nums[idx] = (-1) * nums[idx];
			}
		}
		return -1; 
	}
}
