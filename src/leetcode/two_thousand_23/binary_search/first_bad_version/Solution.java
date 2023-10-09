package leetcode.two_thousand_23.binary_search.first_bad_version;

public class Solution {
    public int badVersion;
    public Solution(int badVersion) {
        this.badVersion = badVersion;
    }
    private boolean isBadVersion(int n) {
        if(n == this.badVersion) {
            return true;
        } else {
            return false;
        }
    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                if(isBadVersion(mid + 1)) {
                    right = mid;
                } else {
                    return mid;
                }
            } else {
                left = mid + 1;
            }
        }
        if(isBadVersion(left)) {
            return left;
        }
        return 1;
    }
}
