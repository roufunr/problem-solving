package leetcode.two_thousand_24.recursion.reverse_linked_list;


class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { 
        this.val = val; 
    }
    public ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
        
    } 
}
