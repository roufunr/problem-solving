package leetcode.daily_challenge.july_25.maximum_unique_subarray_sum_after_deletion_25;

import java.util.*;

public class Solution {
	public int maxSum(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		int neg = Integer.MIN_VALUE;
		for(int n : nums) {
			if(set.contains(n) || n < 0) {
				if(n < 0) {
					neg = Math.max(n , neg);
				}
				continue;
			}
			sum += n;
			set.add(n);
		}
		return set.size() > 0 ? sum : neg;
	}
}
