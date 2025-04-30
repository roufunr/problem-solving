package leetcode.daily_challenge.april_25.count_number_of_digits_even_30;

public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            int cnt = 0;
            while(num > 0) {
                cnt += 1;
                num /= 10;
            }
            if(cnt % 2 == 0) {
                count++;
            } 
        }
        return count;
    }
}