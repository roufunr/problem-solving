package leetcode.two_thousand_23.linked_list.design_doubly_linked_list;

public class Runner {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(0);
        myLinkedList.printLinkedList();
        myLinkedList.addAtIndex(1,4);
        myLinkedList.printLinkedList();
        myLinkedList.addAtTail(8);
        myLinkedList.printLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.printLinkedList();
        myLinkedList.addAtIndex(4, 3);
        myLinkedList.printLinkedList();
        myLinkedList.addAtTail(0);
        myLinkedList.printLinkedList();
        myLinkedList.addAtTail(5);
        myLinkedList.printLinkedList();
        myLinkedList.addAtIndex(6, 5);
        myLinkedList.printLinkedList();
        myLinkedList.deleteAtIndex(7);
        myLinkedList.printLinkedList();
        myLinkedList.deleteAtIndex(5);
        myLinkedList.printLinkedList();
        myLinkedList.addAtTail(4);
        myLinkedList.printLinkedList();
    }
}
//
//["MyLinkedList","addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtTail","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtTail"]
//        [[],[0],[1,4],[8],[5],[4,3],[0],[5],[6,3],[7],[5],[4]]
