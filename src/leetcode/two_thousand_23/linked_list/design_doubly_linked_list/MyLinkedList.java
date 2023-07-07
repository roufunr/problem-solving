package leetcode.two_thousand_23.linked_list.design_doubly_linked_list;

class Node {
    public int val;
    public Node next;
    public Node prev;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {
    // https://leetcode.com/explore/learn/card/linked-list/210/doubly-linked-list/1294/
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if(head == null || index < 0 || index >= size) {
            return -1;
        }
        Node itr = head;
        int i = 0;
        while(itr != null) {
            if(index == i) {
                return itr.val;
            }
            itr = itr.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }

    public void printLinkedList() {
        Node itrNode = head;
        System.out.println("---- printing the list ----");
        System.out.println("Size: " + size);
        for(int i = 0; i < size; i++) {
            System.out.print(itrNode.val);
            itrNode = itrNode.next;
            if(i !=  size - 1) System.out.print(" -> ");
        }
        System.out.println("\n-----------------------------");
    }
}