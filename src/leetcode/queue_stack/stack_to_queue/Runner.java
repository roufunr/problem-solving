package leetcode.queue_stack.stack_to_queue;

public class Runner {
    public static void main(String[] args) {
        //["MyQueue", "push", "push", "peek", "pop", "empty"]
        //[[], [1], [2], [], [], []]
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);


        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
