package leetcode.two_thousand_23.queue_stack.minstack;
import java.util.*;

class Pair {
    public int val;
    public int min;
}
public class MinStack {
    private Stack<Pair> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        Pair newPair = new Pair();
        newPair.val = val;
        if(stack.empty()) {
            newPair.min = val;
            stack.push(newPair);
        } else {
            int min = val < stack.peek().min ? val : stack.peek().min;
            newPair.min = min;
            stack.push(newPair);
        }
    }
    
    public void pop() {
        if(!stack.empty()) {
            stack.pop();
        }
    }
    
    public int top() {
        if(!stack.empty()) {
            return stack.peek().val;
        } else {
            return -1;
        }
    }
    
    public int getMin() {
        if(!stack.empty()) {
            return stack.peek().min;
        } else {
            return -1;
        }
    }
}

