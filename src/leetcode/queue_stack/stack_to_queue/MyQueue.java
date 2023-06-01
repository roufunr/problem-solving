package leetcode.queue_stack.stack_to_queue;

import java.util.Stack;

public class MyQueue {
    //https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
    private Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
    }
    public int pop() {
        if(empty()) {
            return -1;
        } else {
            Stack<Integer> tempStack = new Stack<>();
            while (!empty()) {
                tempStack.push(stack.pop());
            }
            int target = tempStack.pop();
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return target;
        }
    }
    public int peek() {
        if(empty()) {
            return -1;
        } else {
            Stack<Integer> tempStack = new Stack<>();
            while (!empty()) {
                tempStack.push(stack.pop());
            }
            int target = tempStack.peek();
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            return target;
        }
    }
    public boolean empty() {
        return stack.isEmpty();
    }
}