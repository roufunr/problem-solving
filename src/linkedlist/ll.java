package linkedlist;

import leetcode.two_thousand_22.linkedList.ListNode;

public class ll {
    public ListNode constructLinkedList(int[] head) {
        if (head == null || head.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1); 
        ListNode current = dummy; 
        for (int value : head) {
            current.next = new ListNode(value); 
            current = current.next;
        }
        return dummy.next; 
    }
}
