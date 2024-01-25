package leetcode.two_thousand_24.binary_search.split_array_largest_sum;

public class Solution {
    public boolean validPartition(int[] nums, int target, int m) {
        int count = 1;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            if(sum > target) {
                sum = num;
                count++;
                if(count > m) {
                    return false;
                }
            }
        }
        return true;
    }   
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;
            if(num > max) {
                max = num;
            }
        }
        int left = max;
        int right = sum;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(validPartition(nums, mid, k)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
