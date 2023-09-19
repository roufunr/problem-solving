package leetcode.two_thousand_23.queue_stack.implement_queue_using_stack;

import java.util.*;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // A B C D
    // D C B A
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        stack2.clear();
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int poppedItem = stack2.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return poppedItem;
    }
    
    public int peek() {
        stack2.clear();
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int poppedItem = stack2.peek();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return poppedItem;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

