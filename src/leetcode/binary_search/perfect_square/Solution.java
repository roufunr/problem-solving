package leetcode.binary_search.perfect_square;

public class Solution {
    //https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
    private final int HIGHEST_SQRT_RANGE = 46340 * 2;
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = HIGHEST_SQRT_RANGE < num ? HIGHEST_SQRT_RANGE : num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int mid_square = mid * mid;
            if(mid_square == num) {
                return true;
            } else if(mid_square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
