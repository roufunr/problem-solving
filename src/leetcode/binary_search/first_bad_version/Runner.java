package leetcode.binary_search.first_bad_version;

public class Runner {
    public static void main(String[] args) {
        int n = 2147483647;
        int bad = 2147483647;
        Solution solution = new Solution(bad);
        solution.firstBadVersion(n);
    }
}
