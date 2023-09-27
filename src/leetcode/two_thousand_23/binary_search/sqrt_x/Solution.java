package leetcode.two_thousand_23.binary_search.sqrt_x;

public class Solution {
    // need to handle memory overflow that is the most challenging part
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long left = 1;
        long right = x/2;
        long X = (long)x;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(mid * mid == X) {
                return (int)mid;
            } else if (mid * mid > X) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }
}
