package leetcode.binary_search.first_bad_version;

public class VersionControl {
    private int badVersion;

    public VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }
    boolean isBadVersion(int version) {
        if(badVersion <= version) {
            return true;
        } else {
            return false;
        }
    }
}
