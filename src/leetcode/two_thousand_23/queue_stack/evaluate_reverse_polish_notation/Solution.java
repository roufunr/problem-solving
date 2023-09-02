package leetcode.two_thousand_23.queue_stack.evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(str.equals("+")) {
                int secondOprnd = stack.pop();
                int firstOprnd = stack.pop();
                int result = firstOprnd + secondOprnd;
                stack.push(result);
            } else if (str.equals("-")) {
                int secondOprnd = stack.pop();
                int firstOprnd = stack.pop();
                int result = firstOprnd - secondOprnd;
                stack.push(result);
            } else if (str.equals("*")) {
                int secondOprnd = stack.pop();
                int firstOprnd = stack.pop();
                int result = firstOprnd * secondOprnd;
                stack.push(result);
            } else if (str.equals("/")) {
                int secondOprnd = stack.pop();
                int firstOprnd = stack.pop();
                int result = firstOprnd / secondOprnd;
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
}
