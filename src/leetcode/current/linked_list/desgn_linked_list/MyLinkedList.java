package leetcode.current.linked_list.desgn_linked_list;

public class MyLinkedList {
    private Node head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        Node itrNode = head;
        int i = 0;
        while(i < index) {
            itrNode = itrNode.next;
            i++;
        }
        return itrNode.val;
    }
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(size == 0) {
            head = newNode;
            size++;
            return;
        }
        int i = 0;
        Node itrNode = head;
        while(i < size - 1) {
            itrNode = itrNode.next;
            i++;
        }
        itrNode.next = newNode;
        size++;
    }
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) {
            return;
        }
        Node newNode = new Node(val);
        if(index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node itrNode = head;
        for(int i = 0; i < index - 1; i++) {
            itrNode = itrNode.next;
        }
        newNode.next = itrNode.next;
        itrNode.next = newNode;
        size++;
    }
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node itrNode = head;
        for(int i = 0; i < index - 1; i++) {
            itrNode = itrNode.next;
        }
        itrNode.next = itrNode.next != null ? itrNode.next.next : null;
        size--;
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
