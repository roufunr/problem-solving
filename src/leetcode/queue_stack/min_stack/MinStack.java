package leetcode.queue_stack.min_stack;

import java.util.Map;
import java.util.Stack;
//https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
class Pair{
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}

public class MinStack {
    Stack<Pair> myStack;
    public MinStack() {
        myStack = new Stack<>();
    }

    public void push(int val) {
        if(myStack.isEmpty()) {
            myStack.push(new Pair(val, val));
        } else {
            Pair currentTop = myStack.peek();
            myStack.push(new Pair(val, Math.min(currentTop.getSecond(), val)));
        }
    }

    public void pop() {
        if(myStack.isEmpty()) {
            //do nothing
            return;
        } else {
           myStack.pop();
        }
    }

    public int top() {
        if(myStack.isEmpty()) {
            return -1;
        } else {
            return myStack.peek().getFirst();
        }
    }

    public int getMin() {
        if(myStack.isEmpty()) {
            return -1;
        } else {
            return myStack.peek().getSecond();
        }
    }
}