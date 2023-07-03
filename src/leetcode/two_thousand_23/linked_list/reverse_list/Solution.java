package leetcode.two_thousand_23.linked_list.reverse_list;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode topNode = head;
            head = head.next;
            topNode.next = newHead;
            newHead = topNode;
        }
        head = newHead;
        return head;
    }
}
