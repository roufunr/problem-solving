package leetcode.binary_search.first_bad_version;

public class Solution extends VersionControl{
//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
    public Solution(int badVersion) {
        super(badVersion);
    }

    public int firstBadVersion(int n) {
        long left = 1;
        long right = 1L + n;

        while(left < right) {
            int mid = (int) (left + (right - left) / 2);
            if(!isBadVersion(mid) && isBadVersion(mid + 1)) {
                return (mid + 1);
            } else if (!isBadVersion(mid) && !isBadVersion(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(left <= n && isBadVersion((int) left)) {
            return (int) left;
        } else {
            return -1;
        }
    }
}
