package leetcode.current.linked_list.desgn_linked_list;

public class MyLinkedList {
    private Node head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    public int get(int index) {
        Node node = head;
        int itr = 0;
        while(node != null && itr < index) {
            node = node.next;
            itr++;
        }
        if(node == null) {
            return -1;
        } else {
            return node.val;
        }
    }
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head!=null) {
            newNode.next = head.next;
        }
        head = newNode;
        size++;
    }
    public void addAtTail(int val) {
        Node itrNode = head;
        Node newNode = new Node(val);
        size++;
        if(head == null) {
            head = newNode;
            return;
        }
        while(itrNode.next != null) {
            itrNode = itrNode.next;
        }
        itrNode.next = newNode;
    }
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        size++;
        Node node = head;
        int i = 0;
        while(i < index - 1) {
            node = node.next;
            i++;
        }
        Node newNode = new Node(val);
        newNode.next = node.next;
        node.next = newNode;
    }
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        Node node = head;
        if(index == 0 && size >= 1) {
            head = head.next;
            size--;
            return;
        }

        int i = 0;
        while(i < index - 1) {
            node = node.next;
            i++;
        }
        if(i < size - 1) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
        size--;
    }
}
