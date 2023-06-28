package leetcode.current.linked_list.desgn_linked_list;

public class Runner {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.printLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.printLinkedList();
//        myLinkedList.addAtTail(3);
//        myLinkedList.printLinkedList();
//        myLinkedList.addAtIndex(1, 2);     // linked list becomes 1->2->3
//        myLinkedList.printLinkedList();
//        System.out.println(myLinkedList.get(1));                         // return 2
//        myLinkedList.printLinkedList();
//        myLinkedList.deleteAtIndex(1);               // now the linked list is 1->3
//        myLinkedList.printLinkedList();
//        System.out.println(myLinkedList.get(1));                         // return 3
//        myLinkedList.printLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.deleteAtIndex(0);

//        ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//        [[],                [7],          [2],      [1],        [3,0],          [2],            [6],        [4],    [4],    [4],        [5,0],      [6]]

//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        myLinkedList.get(4);
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

        myLinkedList.addAtIndex(0, 10);
        myLinkedList.printLinkedList();
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(1, 30);
        myLinkedList.get(0);
        myLinkedList.printLinkedList();

    }
}
