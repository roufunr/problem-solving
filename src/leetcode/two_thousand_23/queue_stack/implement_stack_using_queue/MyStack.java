package leetcode.two_thousand_23.queue_stack.implement_stack_using_queue;
import java.util.*;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
        while(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
    }
    
    public int pop() {
        if(queue2.isEmpty()) {
            return -1;
        } else {
            return queue2.poll();
        }
    }
    
    public int top() {
        if(queue2.isEmpty()) {
            return -1;
        } else {
            return queue2.peek();
        }
    }
    
    public boolean empty() {
        return queue2.isEmpty();
    }
}
