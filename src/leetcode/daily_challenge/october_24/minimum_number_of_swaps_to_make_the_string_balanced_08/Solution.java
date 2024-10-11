package leetcode.daily_challenge.october_24.minimum_number_of_swaps_to_make_the_string_balanced_08;

import java.util.Stack;

public class Solution {

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack();
        int unbalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If an opening bracket is encountered, push it in the stack.
            if (ch == '[') stack.push(ch);
            else {
                // If the stack is not empty, pop it.
                if (!stack.isEmpty()) stack.pop();
                // Otherwise increase the count of unbalanced brackets.
                else unbalanced++;
            }
        }
        return (unbalanced + 1) / 2;
    }
}