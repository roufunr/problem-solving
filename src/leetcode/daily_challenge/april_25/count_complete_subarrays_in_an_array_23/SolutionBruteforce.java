package leetcode.daily_challenge.april_25.count_complete_subarrays_in_an_array_23;

import java.util.HashSet;
import java.util.Set;

public class SolutionBruteforce {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                Set<Integer> tempSet = new HashSet<>();
                for(int k = i; k <= j; k++) {
                    tempSet.add(nums[k]);
                }
                if(tempSet.size() == set.size()) {
                    count++;
                }
            }
        }
        return count;
    }
}
