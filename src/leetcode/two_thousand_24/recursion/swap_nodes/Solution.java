package leetcode.two_thousand_24.recursion.swap_nodes;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        head.next = head.next.next;
        temp.next = head;
        head = temp;

        head.next.next = swapPairs(head.next.next);
        return head;
    }
}
