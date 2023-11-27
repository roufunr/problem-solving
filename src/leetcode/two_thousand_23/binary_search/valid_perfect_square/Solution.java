package leetcode.two_thousand_23.binary_search.valid_perfect_square;

public class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        long N = num;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(mid * mid == N) {
                return true;
            } else if (mid * mid > N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // here the critical part is data type
}
