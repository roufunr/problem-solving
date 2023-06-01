package leetcode.queue_stack.evaluate_reverse_polish_notation;

public class Runner {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        new Solution().evalRPN(tokens);
    }
}
