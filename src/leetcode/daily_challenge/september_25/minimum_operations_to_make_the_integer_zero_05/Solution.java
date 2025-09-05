package leetcode.daily_challenge.september_25.minimum_operations_to_make_the_integer_zero_05;

public class Solution {
    private long numBits(long n) {
        long x = n;
        long count = 0;
        while(x > 0) {
            count += x % 2;
            x /= 2;
        }
        return count;
    }
    public int makeTheIntegerZero(int num1, int num2) {
        long x = 1;
        while(true) {
            long y = (long)(num1 - (x * num2));
            // System.out.println(i + ">>" + numBits((int)val) + ">>" + val);
            if(y < x) {
                return -1;
            }
            if(numBits(y) <= x) {
                return (int)x;
            }
            x++;
        }
    }
}
