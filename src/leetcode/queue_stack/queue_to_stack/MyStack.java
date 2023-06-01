package leetcode.queue_stack.queue_to_stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    //https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            if(i == size - 1) {
                return queue.remove();
            } else {
                queue.add(queue.remove());
            }
        }
        return -1;
    }

    public int top() {
        int size = queue.size();
        int peekElement = -1;
        for(int i = 0; i < size; i++) {
            if(i == size - 1) {
                peekElement = queue.peek();
            }
            queue.add(queue.remove());
        }
        return peekElement;
    }
    public boolean empty() {
        return queue.isEmpty();
    }
}
