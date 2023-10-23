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
        int l = 1;
        int r = n;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(!isBadVersion(mid)) {
                if(isBadVersion(mid + 1)) {
                    return mid + 1;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid;
            }
        }
        if(!isBadVersion(l)) {
            return l + 1;
        }
        return l;
    }
}
