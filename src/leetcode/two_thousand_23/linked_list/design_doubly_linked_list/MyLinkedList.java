package leetcode.two_thousand_23.linked_list.design_doubly_linked_list;

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    private Node head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    public int get(int index) {

    }
    public void addAtHead(int val) {

    }
    public void addAtTail(int val) {

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