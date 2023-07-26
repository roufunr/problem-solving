package leetcode.two_thousand_23.arrays_and_strings.two_sum_II;
import java.util.HashMap;
import java.util.Map;
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
