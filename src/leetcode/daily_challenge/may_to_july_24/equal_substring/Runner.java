package leetcode.daily_challenge.may_to_july_24.equal_substring;

public class Runner {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "cdef";
        int maxCost = 1;

        System.out.println(new Solution().equalSubstring(str1, str2, maxCost));

    }
}
