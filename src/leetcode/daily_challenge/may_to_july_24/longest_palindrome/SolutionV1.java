package leetcode.daily_challenge.may_to_july_24.longest_palindrome;

import java.util.HashSet;
import java.util.Set;

// set based solution 
// better
// clean code
public class SolutionV1 {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                result += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (set.size() >= 1) {
            result += 1;
        }
        return result;
    }
}
