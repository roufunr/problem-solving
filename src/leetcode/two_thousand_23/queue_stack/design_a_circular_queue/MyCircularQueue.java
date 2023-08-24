package leetcode.two_thousand_23.queue_stack.design_a_circular_queue;

public class MyCircularQueue {
    private int buf_size;
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    public MyCircularQueue(int k) {
        this.buf_size = k;
        this.buffer = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isEmpty()) {
            head = 0;
            tail = 0;
            buffer[head] = value;
            size++;
            return true;
        } else if(isFull()) {
            return false;
        } else {
            tail = (tail + 1) % buf_size;
            buffer[tail] = value;
            size++;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        } else if(size == 1) {
            head = -1;
            tail = -1;
            size--;
            return true;
        } else {
            head = (head + 1) % buf_size;
            size--;
            return true;
        }
    }
    
    public int Front() {
        if(head == -1) {
            return -1;
        }

        return buffer[head];
    }
    
    public int Rear() {
        if(tail == -1) {
            return -1;
        }

        return buffer[tail];
    }
    
    public boolean isEmpty() {
        if(head == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull() {
        if(size == buf_size) {
            return true;
        } else {
            return false;
        }
    }
}
