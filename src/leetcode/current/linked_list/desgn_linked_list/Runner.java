package leetcode.current.linked_list.desgn_linked_list;

public class Runner {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);     // linked list becomes 1->2->3
//        System.out.println(myLinkedList.get(1));;                         // return 2
//        myLinkedList.deleteAtIndex(1);               // now the linked list is 1->3
//        System.out.println(myLinkedList.get(1));                         // return 3
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(0);
    }
}
