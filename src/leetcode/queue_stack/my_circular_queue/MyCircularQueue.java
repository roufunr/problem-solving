package leetcode.queue_stack.my_circular_queue;

public class MyCircularQueue {
    private int size;
    private int[] queue;
    private Integer head, tail;

    public MyCircularQueue(int k) {
        size = k;
        queue = new int[size];
        head = null;
        tail = null;
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        } else {
            if(isEmpty()) {
                head = 0;
                tail = 0;
                queue[head] = value;
            } else {
                tail = (tail + 1) % size;
                queue[tail] = value;
            }
            return true;
        }
    }

    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        } else {
            if(head == tail) {
                head = null;
                tail = null;
            } else {
                queue[head] = 0;
                head = (head + 1) % size;
            }
            return true;
        }
    }

    public int Front() {
        if(head!=null) {
            return queue[head];
        } else {
            return -1;
        }
    }

    public int Rear() {
        if(tail!=null) {
            return queue[tail];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        if(head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if(head !=null && tail != null) {
            if((tail + 1)%size == head) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
