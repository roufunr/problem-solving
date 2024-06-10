package leetcode.extras.is_palindrome;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // converting to a char array
    // accepted buthas roam for update
    public boolean

            Palindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Character> digits = new ArrayList<>();
        while (x != 0) {
            int remainder = x % 10;
            digits.add((char) (remainder + '0'));
            x /= 10;
        }
        for (int i = 0; i < (digits.size() / 2); i++) {
            if (digits.get(i) != digits.get(digits.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
