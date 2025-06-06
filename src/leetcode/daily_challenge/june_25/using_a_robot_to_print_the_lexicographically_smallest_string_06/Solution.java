package leetcode.daily_challenge.june_25.using_a_robot_to_print_the_lexicographically_smallest_string_06;
import java.util.Stack;

public class Solution {
    
    public String robotWithString(String s) {
        int[] counter = new int[26];
        for(char c : s.toCharArray()) {
            counter[(int)(c - 'a')]++;
        }
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char minimumChar = 'a';
        for(char c : s.toCharArray()) {
            stack.push(c);
            counter[(int)(c - 'a')]--;
            while(minimumChar != 'z' && counter[(int)(minimumChar - 'a')] == 0) {
                minimumChar = (char)(minimumChar + 1);
            }
            while(!stack.isEmpty() && stack.peek() <= minimumChar) {
                ans.append(stack.pop());
            }
        }
        return ans.toString();
    }
}