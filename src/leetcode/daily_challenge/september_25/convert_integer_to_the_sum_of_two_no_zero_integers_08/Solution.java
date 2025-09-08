package leetcode.daily_challenge.september_25.convert_integer_to_the_sum_of_two_no_zero_integers_08;

public class Solution {
    private int countZero(int n) {
        int x = n;
        int count = 0;
        while(x > 0) {
            count += x % 10 == 0 ? 1 : 0;
            x /= 10;
        }
        return count;
    }
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n/2; i++) {
            if(countZero(i) == 0 && countZero(n - i) == 0) {
                return new int[]{i , n-i};
            }
        }
        return new int[]{1, n - 1};
    }
}