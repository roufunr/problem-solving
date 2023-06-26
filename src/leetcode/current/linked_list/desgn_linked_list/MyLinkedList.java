package leetcode.current.linked_list.desgn_linked_list;

public class MyLinkedList {
    private Node head;
    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        Node node = head;
        int itr = 0;
        while(node != null && itr <= index) {
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
    }

    public void addAtTail(int val) {
        Node itrNode = head;
        Node newNode = new Node(val);
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

    }

    public void deleteAtIndex(int index) {

    }
}
