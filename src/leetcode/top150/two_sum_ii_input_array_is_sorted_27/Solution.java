package leetcode.top150.two_sum_ii_input_array_is_sorted_27;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                int[] ans ={i + 1, j + 1};
                return ans;
            }
        }
        int[] ans ={-1, -1};
        return ans;
    }
}