package leetcode.binary_search.sqrt_x;
//https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
public class Solution {
    public int mySqrt(int x) {
        long left = 1;
        long right = x;
        long mid;
        mid = (left + right) / 2;
        int itr = 0;
        while(left<=right) {
            if(mid * mid == x) {
                break;
            } else if(mid * mid > x) {
                right = mid - 1;
            } else if(mid * mid < x) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
            System.out.println(itr++);
        }
        return (int)mid;
    }
}
