package leetcode.extras.is_palindrome;

public class SolutionV1 {
    public boolean Palindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + (x % 10);
            x /= 10;
        }
        if (x == reverseNum) {
            return true;
        } else if (x == (reverseNum / 10)) {
            return true;
        } else {
            return false;
        }
    }
}
